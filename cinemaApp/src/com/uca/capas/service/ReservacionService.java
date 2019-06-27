package com.uca.capas.service;

import com.uca.capas.domain.Reservacion;

public interface ReservacionService {

	public Reservacion procesarReservacion(Reservacion r);
	
	public void addReservacion(Reservacion r) throws Exception;
}
