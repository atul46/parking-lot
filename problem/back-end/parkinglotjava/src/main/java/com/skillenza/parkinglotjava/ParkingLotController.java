package com.skillenza.parkinglotjava;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;




/**
 * The Class ParkingLotController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
@Slf4j
public class ParkingLotController {

	/** The parking lot service. */
	@Autowired
	ParkingLotService parkingLotService;
	
	/**
	 * Gets the all parking data.
	 *
	 * @return {@link ParkingLotResponseDto}
	 */
	@GetMapping("/parkings")
	public ParkingLotResponseDto getAllParkingData() {
		log.debug("Entered into the get-All-parking-data controller");
		return  parkingLotService.getAllParkingLotDetails();
	}
	
	/**
	 * Creates the paking lot details.
	 *
	 * @param parkingLot the parking lot
	 * @return the parking lot
	 */
	@PostMapping("/parkings")
	public ParkingLot createPakingLotDetails(@RequestBody @Valid ParkingLot parkingLot) {
		log.debug("Entered into the create-Parking-lot-details controller");
		return parkingLotService.storeParkingDetails(parkingLot);
	}
}

