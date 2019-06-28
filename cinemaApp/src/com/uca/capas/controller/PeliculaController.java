package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.response.PeliculaResponse;
import com.uca.capas.domain.response.UsuarioResponse;
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
	
	@RequestMapping("/perfilPelicula")
	public ModelAndView perfilPelicula(int id) {
		ModelAndView mav = new ModelAndView();
		Pelicula p = peliculaService.findOne(id);
		mav.addObject("pelicula", p);
		mav.addObject("exhibiciones",p.getExhibiciones());
		mav.setViewName("perfilPelicula");
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
	public ModelAndView addPelicula(@Valid @ModelAttribute Pelicula p, BindingResult result){
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("pelicula", p);
			mav.addObject("formAction", "addPelicula");
			mav.setViewName("formPelicula");
		}else {
			peliculaService.addPelicula(p);
			mav.setViewName("redirect:/tablaPelicula");
		}
		return mav;
	}
	
	@RequestMapping("/editPelicula")
	public ModelAndView editPelicula(@Valid @ModelAttribute Pelicula p, BindingResult result){
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("pelicula", p);
			mav.addObject("formAction", "editPelicula");
			mav.setViewName("formPelicula");
		}else {
			peliculaService.editPelicula(p);
			mav.setViewName("redirect:/tablaPelicula");
		}
		return mav;
	}
	
	@RequestMapping("/activarPelicula")
	public ModelAndView activarPelicula(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		peliculaService.activarPelicula(id);
		mav.setViewName("redirect:/tablaPelicula");
		return mav;
	}
	
	@RequestMapping(value = "/verPelicula", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PeliculaResponse verPelicula(@RequestParam int id) {
		Pelicula p = peliculaService.findOne(id);
		PeliculaResponse pr = new PeliculaResponse();
		pr.setDescripcion(p.getDescripcion());
		pr.setNombre(p.getNombre());
		return pr;
	}
}
