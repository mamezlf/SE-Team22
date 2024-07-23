/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import app.AppException;

/**
 * Form class for Reserve Room
 * 
 */
public class CancelRoomForm {

	private CancelRoomControl cancelRoomHandler = new CancelRoomControl();

	private String reservationNumber;

	private CancelRoomControl getCancelRoomHandler() {
		return cancelRoomHandler;
	}

	public void submitCancel() throws AppException {
		CancelRoomControl cancelRoomHandler = getCancelRoomHandler();
		cancelRoomHandler.cancelReservation(reservationNumber);
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}
