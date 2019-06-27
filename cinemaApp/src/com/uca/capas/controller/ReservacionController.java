package com.uca.capas.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Reservacion;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.ExhibicionService;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.ReservacionService;
import com.uca.capas.utils.Constants;

@Controller
public class ReservacionController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private ExhibicionService exhibicionService;
	
	@Autowired
	private ReservacionService reservacionService;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/reservacion")
	public ModelAndView reservacion(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		Pelicula p = peliculaService.findOne(id);
		mav.addObject("pelicula", p);
		mav.addObject("exhibiciones", p.getExhibiciones());
		mav.addObject("reservacion", new Reservacion());
		mav.setViewName("reservacion");
		return mav;
	}
	
	@RequestMapping("/confirmarReservacion")
	public ModelAndView confirmarReservacion(@ModelAttribute Reservacion r) {
		ModelAndView mav = new ModelAndView();
		Exhibicion e = exhibicionService.findOne(r.getIdExhibicion());
		r = reservacionService.procesarReservacion(r);
		mav.addObject("exhibicion",e);
		mav.addObject("reservacion", r);
		mav.setViewName("confirmarReservacion");
		return mav;
	}
	
	@RequestMapping("/procesarReservacion")
	public ModelAndView procesarReservacion(@ModelAttribute Reservacion r) {
		ModelAndView mav = new ModelAndView();
		try {
			reservacionService.addReservacion(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/peliculas");
		return mav;
	}
	
	@RequestMapping("/transacciones")
	public ModelAndView transacciones() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tablaTransacciones");
		return mav;
	}
	
	@RequestMapping("/buscarTransacciones")
	public ModelAndView buscarTransacciones(@DateTimeFormat(pattern="yyyy-MM-dd")Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate) {
		ModelAndView mav = new ModelAndView();
		Usuario u = (Usuario)session.getAttribute(Constants.USER_SESSION);
		mav.addObject("reservaciones", reservacionService.findByUserAndDate(u.getId(), startDate, endDate));
		mav.setViewName("tablaTransacciones");
		return mav;
	}
}
