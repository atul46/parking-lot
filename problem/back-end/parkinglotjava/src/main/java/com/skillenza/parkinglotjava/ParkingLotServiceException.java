package com.skillenza.parkinglotjava;

/**
 * Custom Exception Class in case of error occurred in services.
 * 
 *
 */
public class ParkingLotServiceException extends RuntimeException {

	/**
	 * Generated serial version id
	 */
	private static final long serialVersionUID = 8621530697947108810L;

	/**
	 * Constructor the initialize Handler exception
	 * 
	 * @param errorCode
	 *            The error code for this exception
	 * @param errorMessage
	 *            The error message for this exception
	 */
	public ParkingLotServiceException(String errorCode, String errorMessage) {
		super(errorCode + "--->" + errorMessage);
	}

	/**
	 * Constructor the initialize Handler exception
	 * 
	 * @param errorCode
	 *            The error code for this exception
	 * @param errorMessage
	 *            The error message for this exception
	 * @param rootCause
	 *            the specified cause
	 */
	public ParkingLotServiceException(String errorCode, String errorMessage, Throwable rootCause) {
		super(errorCode + "--->" + errorMessage + "---->" + rootCause);
	}

}
