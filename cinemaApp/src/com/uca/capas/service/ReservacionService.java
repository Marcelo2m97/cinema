package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import com.uca.capas.domain.Reservacion;

public interface ReservacionService {

	public Reservacion procesarReservacion(Reservacion r) throws Exception;
	
	public Reservacion findOne(int id);
	
	public void addReservacion(Reservacion r) throws Exception;
	
	public List<Reservacion> findByUserAndDate(int userId, Date startDate, Date endDate);
}
