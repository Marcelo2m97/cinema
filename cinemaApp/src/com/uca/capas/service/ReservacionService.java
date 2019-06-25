package com.uca.capas.service;

import com.uca.capas.dto.ReservacionDTO;

public interface ReservacionService {

	public ReservacionDTO procesarDTO(ReservacionDTO dto);
	
	public void procesarReservacion(ReservacionDTO dto);
}
