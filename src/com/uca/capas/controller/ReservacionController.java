package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Pelicula;
import com.uca.capas.dto.ReservacionDTO;
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
		mav.addObject("reservacion", new ReservacionDTO());
		mav.setViewName("reservacion");
		return mav;
	}
	
	@RequestMapping("/confirmarReservacion")
	public ModelAndView confirmarReservacion(@ModelAttribute ReservacionDTO dto) {
		ModelAndView mav = new ModelAndView();
		Exhibicion e = exhibicionService.findOne(dto.getIdExhibicion());
		dto = reservacionService.procesarDTO(dto);
		mav.addObject("exhibicion",e);
		mav.addObject("reservacion", dto);
		mav.setViewName("confirmarReservacion");
		return mav;
	}
	
	@RequestMapping("/procesarReservacion")
	public ModelAndView procesarReservacion(@ModelAttribute ReservacionDTO dto) {
		ModelAndView mav = new ModelAndView();
		System.out.println("DTO "+dto.getGranTotal());
		reservacionService.procesarReservacion(dto);
		mav.setViewName("redirect:/peliculas");
		return mav;
	}
}
