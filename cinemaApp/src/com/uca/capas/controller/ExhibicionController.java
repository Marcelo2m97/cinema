package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.service.ExhibicionService;
import com.uca.capas.service.FormatoService;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.SalaService;

@Controller
public class ExhibicionController {
	
	@Autowired
	private ExhibicionService exhibicionService;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private FormatoService formatoService;
	
	@RequestMapping("/tablaExhibicion")
	public ModelAndView tablaExhibicion() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exhibiciones", exhibicionService.findAll());
		mav.setViewName("tablaExhibicion");
		return mav;
	}
	
	@RequestMapping("/formAddExhibicion")
	public ModelAndView formExhibicion(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exhibicion", new Exhibicion());
		mav.addObject("salas", salaService.findAll());
		mav.addObject("peliculas", peliculaService.findAll());
		mav.addObject("formatos", formatoService.findAll());
		mav.addObject("formAction", "addExhibicion");
		mav.setViewName("formExhibicion");
		return mav;
	}
	
	@RequestMapping("/formEditExhibicion")
	public ModelAndView formExhibicion(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Exhibicion e = exhibicionService.findOne(id);
		mav.addObject("exhibicion", e);
		mav.addObject("salas", salaService.findAll());
		mav.addObject("peliculas", peliculaService.findAll());
		mav.addObject("formatos", formatoService.findAll());
		mav.addObject("formAction", "editExhibicion");
		mav.setViewName("formExhibicion");
		return mav;
	}
	
	@RequestMapping("/addExhibicion")
	public ModelAndView addExhibicion(@ModelAttribute Exhibicion e){
		ModelAndView mav = new ModelAndView();
		exhibicionService.addExhibicion(e);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
	
	@RequestMapping("/editExhibicion")
	public ModelAndView editExhibicion(@ModelAttribute Exhibicion e){
		ModelAndView mav = new ModelAndView();
		exhibicionService.editExhibicion(e);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
	
	@RequestMapping("/activarExhibicion")
	public ModelAndView activarExhibicion(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		exhibicionService.activarExhibicion(id);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
}