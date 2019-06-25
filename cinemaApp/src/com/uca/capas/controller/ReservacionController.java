package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.repositories.PeliculaRepository;

@Controller
public class ReservacionController {
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@RequestMapping("reservacion")
	public ModelAndView reservacion(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		Pelicula p = peliculaRepository.findOne(id);
		mav.addObject("pelicula", p);
		mav.addObject("exhibiciones", p.getExhibiciones());
		mav.setViewName("reservacion");
		return mav;
	}
}
