/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationException;
import domain.reservation.ReservationManager;
import domain.room.RoomManager;

/**
 * Control class for Reserve Room
 * 
 */
public class CancelRoomControl {

	public void cancelReservation(String reservationNumber) throws AppException {
		//Permitting only one night so that change amount of availableQty is always -1
		try {

			//Create reservation
			ReservationManager reservationManager = getReservationManager();
			reservationManager.cancelReservation(reservationNumber);
		}

		catch (ReservationException e) {
			AppException exception = new AppException("Failed to cancel", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}

	private RoomManager getRoomManager() {
		return ManagerFactory.getInstance().getRoomManager();
	}

	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}
}