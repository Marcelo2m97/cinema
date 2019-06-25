package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.service.PeliculaService;

@Controller
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;
	
	@RequestMapping("/peliculas")
	public ModelAndView verPeliculas() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("peliculas", peliculaService.findActive());
		mav.setViewName("peliculas");
		return mav;
	}
	
	@RequestMapping("/tablaPelicula")
	public ModelAndView tablaPelicula() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("peliculas", peliculaService.findAll());
		mav.setViewName("tablaPelicula");
		return mav;
	}
	
	@RequestMapping("/formAddPelicula")
	public ModelAndView formPelicula(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pelicula", new Pelicula());
		mav.addObject("formAction", "addPelicula");
		mav.setViewName("formPelicula");
		return mav;
	}
	
	@RequestMapping("/formEditPelicula")
	public ModelAndView formPelicula(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Pelicula p = peliculaService.findOne(id);
		mav.addObject("pelicula", p);
		mav.addObject("formAction", "editPelicula");
		mav.setViewName("formPelicula");
		return mav;
	}
	
	@RequestMapping("/addPelicula")
	public ModelAndView addPelicula(@ModelAttribute Pelicula p){
		ModelAndView mav = new ModelAndView();
		peliculaService.addPelicula(p);
		mav.setViewName("redirect:/tablaPelicula");
		return mav;
	}
	
	@RequestMapping("/editPelicula")
	public ModelAndView editPelicula(@ModelAttribute Pelicula p){
		ModelAndView mav = new ModelAndView();
		peliculaService.editPelicula(p);
		mav.setViewName("redirect:/tablaPelicula");
		return mav;
	}
	
	@RequestMapping("/activarPelicula")
	public ModelAndView activarPelicula(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Pelicula p = peliculaService.findOne(id);
		peliculaService.activarPelicula(p);
		mav.setViewName("redirect:/tablaPelicula");
		return mav;
	}
}
