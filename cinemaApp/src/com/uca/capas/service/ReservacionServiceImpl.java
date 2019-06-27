package com.uca.capas.service;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Reservacion;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.ExhibicionRepository;
import com.uca.capas.repositories.ReservacionRepository;
import com.uca.capas.repositories.UsuarioRepository;
import com.uca.capas.utils.Constants;

@Service
public class ReservacionServiceImpl implements ReservacionService{

	@Autowired
	private ExhibicionRepository exhibicionRepository;
	
	@Autowired
	private ReservacionRepository reservacionRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private HttpSession session;
	
	@Override
	public Reservacion procesarReservacion(Reservacion r) {
		Exhibicion e = exhibicionRepository.findOne(r.getIdExhibicion());
		Usuario u = (Usuario)session.getAttribute(Constants.USER_SESSION);
		if (r.getSaldo() == null) {
			r.setSaldo(BigDecimal.ZERO);
		}
		r.setSubtotal(e.getFormato().getPrecio().multiply(BigDecimal.valueOf(r.getAsientos())));
		BigDecimal saldoSobrante = BigDecimal.ZERO;
		if (r.getSaldo().compareTo(r.getSubtotal()) == 1) {
			saldoSobrante = r.getSaldo().subtract(r.getSubtotal());
		}
		BigDecimal saldoUsado = r.getSaldo().subtract(saldoSobrante);
		r.setSaldoRestante(u.getSaldo().subtract(saldoUsado));
		r.setTotal(r.getSubtotal().subtract(saldoUsado));
		return r;
	}

	@Override
	@Transactional(rollbackOn=Exception.class)
	public void addReservacion(Reservacion r) throws Exception {
		Exhibicion e = exhibicionRepository.findOne(r.getIdExhibicion());
		Usuario u = (Usuario)session.getAttribute(Constants.USER_SESSION);
		if (e.getAsientos() < r.getAsientos()) {
			throw new Exception();
		}
		e.setAsientos(e.getAsientos()-r.getAsientos());
		exhibicionRepository.save(e);
		r.setExhibicion(e);
		if (u.getSaldo().compareTo(r.getSaldo()) == -1) {
			throw new Exception();
		}
		u.setSaldo(r.getSaldoRestante());
		usuarioRepository.save(u);
		r.setUsuario(u);
		r.setFecha(Calendar.getInstance());
		reservacionRepository.save(r);
	}
}
