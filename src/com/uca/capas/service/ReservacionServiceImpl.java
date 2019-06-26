package com.uca.capas.service;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Reservacion;
import com.uca.capas.dto.ReservacionDTO;
import com.uca.capas.repositories.ExhibicionRepository;
import com.uca.capas.repositories.ReservacionRepository;

@Service
public class ReservacionServiceImpl implements ReservacionService{

	@Autowired
	private ExhibicionRepository exhibicionRepository;
	
	@Autowired
	private ReservacionRepository reservacionRepository;
	
	@Override
	public ReservacionDTO procesarDTO(ReservacionDTO dto) {
		Exhibicion e = exhibicionRepository.findOne(dto.getIdExhibicion());
		if (dto.getSaldo() == null) {
			dto.setSaldo(BigDecimal.ZERO);
		}
		dto.setSubtotal(e.getFormato().getPrecio().multiply(BigDecimal.valueOf(dto.getAsientos())));
		//dto.setSaldoRestante(null);
		dto.setGranTotal(dto.getSubtotal().subtract(dto.getSaldo()));
		return dto;
	}

	@Override
	@Transactional
	public void procesarReservacion(ReservacionDTO dto) {
		Reservacion r = new Reservacion();
		r.setSaldo(dto.getSaldo());
		r.setTotal(dto.getGranTotal());
		r.setAsientos(dto.getAsientos());
		r.setExhibicion(exhibicionRepository.findOne(dto.getIdExhibicion()));
		//r.setUsuario(null);
		r.setFecha(Calendar.getInstance());
		reservacionRepository.save(r);
	}
}
