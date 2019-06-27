package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Reservacion;
import com.uca.capas.service.ExhibicionService;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.ReservacionService;

@Controller
public class ReservacionController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private ExhibicionService exhibicionService;
	
	@Autowired
	private ReservacionService reservacionService;

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
}
