package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dto.ExhibicionDTO;
import com.uca.capas.service.ExhibicionService;
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
		mav.addObject("exhibicion", new ExhibicionDTO());
		mav.addObject("salas", salaService.findAll());
		mav.addObject("peliculas", peliculaService.findAll());
		mav.addObject("formAction", "addExhibicion");
		mav.setViewName("formExhibicion");
		return mav;
	}
	
	@RequestMapping("/formEditExhibicion")
	public ModelAndView formExhibicion(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		ExhibicionDTO e = exhibicionService.findOne(id);
		mav.addObject("exhibicion", e);
		mav.addObject("salas", salaService.findAll());
		mav.addObject("peliculas", peliculaService.findAll());
		mav.addObject("formAction", "editExhibicion");
		mav.setViewName("formExhibicion");
		return mav;
	}
	
	@RequestMapping("/addExhibicion")
	public ModelAndView addExhibicion(@ModelAttribute ExhibicionDTO e){
		ModelAndView mav = new ModelAndView();
		exhibicionService.addExhibicion(e);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
	
	@RequestMapping("/editExhibicion")
	public ModelAndView editExhibicion(@ModelAttribute ExhibicionDTO e){
		ModelAndView mav = new ModelAndView();
		exhibicionService.editExhibicion(e);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
	
	@RequestMapping("/activarExhibicion")
	public ModelAndView activarExhibicion(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		ExhibicionDTO e = exhibicionService.findOne(id);
		exhibicionService.activarExhibicion(e);
		mav.setViewName("redirect:/tablaExhibicion");
		return mav;
	}
}
