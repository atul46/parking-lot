package com.skillenza.parkinglotjava;

import org.springframework.stereotype.Service;


/**
 * The Interface ParkingLotService.
 */
@Service
public interface ParkingLotService {
 
	/**
	 * Gets the all parking lot details.
	 *
	 * @return {@link ParkingLotResponseDto}
	 */
	ParkingLotResponseDto getAllParkingLotDetails();
	
	/**
	 * Store parking details.
	 *
	 * @param parkingLot the parking lot
	 * @return {@link ParkingLot}
	 */
	ParkingLot storeParkingDetails(ParkingLot parkingLot);
}
