package com.skillenza.parkinglotjava;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class ParkingLotServiceImpl.
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

	/** The parking lot repo. */
	@Autowired
	private ParkingLotRepository parkingLotRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skillenza.parkinglotjava.ParkingLotService#getAllParkingLotDetails()
	 */
	@Override
	public ParkingLotResponseDto getAllParkingLotDetails() {
		ParkingLotResponseDto parkingLotResponseDto = new ParkingLotResponseDto();
		List<ParkingLot> parkingLotDetails = null;
		try {
			parkingLotDetails = parkingLotRepo.findAll();

		} catch (DataRetrievalFailureException e) {
			throw new ParkingLotServiceException("PRK-LOT-100", "Parking lot Details not found");
		}
		Objects.requireNonNull(parkingLotDetails, "Parking lot details is not present in the database");
		if (parkingLotDetails.isEmpty()) {
			throw new ParkingLotServiceException("PRK-LOT-100", "Parking lot Details not found");
		}
		parkingLotResponseDto.setParkingLots(parkingLotDetails);
		return parkingLotResponseDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skillenza.parkinglotjava.ParkingLotService#storeParkingDetails(com.
	 * skillenza.parkinglotjava.ParkingLot)
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public ParkingLot storeParkingDetails(ParkingLot parkingLot) {
		double surplusAmount = 0;
		ParkingLot parkingLotFromDatabase = null;
		if (parkingLot.getParkingDuration() > 60) {
			double parkingLotDuration = parkingLot.getParkingDuration();
			surplusAmount = (parkingLotDuration - 60) * 0.333;
			surplusAmount += 20;
		} else {
			surplusAmount = 20;
		}
		parkingLot.setParkingAmount(surplusAmount);
		try {
			parkingLotFromDatabase = parkingLotRepo.save(parkingLot);
		} catch (DataRetrievalFailureException e) {
			throw new ParkingLotServiceException("PRK-LOT-101", "Error occured while inserting data");
		}
		return parkingLotFromDatabase;
	}

}
