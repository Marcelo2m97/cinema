package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import com.uca.capas.domain.Reservacion;

public interface ReservacionService {

	public Reservacion procesarReservacion(Reservacion r);
	
	public void addReservacion(Reservacion r) throws Exception;
	
	public List<Reservacion> findByUserAndDate(int userId, Date startDate, Date endDate);
}
