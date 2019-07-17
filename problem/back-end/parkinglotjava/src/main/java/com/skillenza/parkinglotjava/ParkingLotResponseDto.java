package com.skillenza.parkinglotjava;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new parking lot response dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new parking lot response dto.
 *
 * @param parkingLots the parking lots
 */
@AllArgsConstructor
public class ParkingLotResponseDto {

	/** The parking lots. */
	private List<ParkingLot> parkingLots;
}
