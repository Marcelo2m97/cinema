package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Sala;
import com.uca.capas.domain.response.SalaResponse;
import com.uca.capas.service.SalaService;

@Controller
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@RequestMapping("/tablaSala")
	public ModelAndView tablaSala() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("salas", salaService.findAll());
		mav.setViewName("tablaSala");
		return mav;
	}
	
	@RequestMapping("/formAddSala")
	public ModelAndView formSala(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("sala", new Sala());
		mav.addObject("formAction", "addSala");
		mav.setViewName("formSala");
		return mav;
	}
	
	@RequestMapping("/formEditSala")
	public ModelAndView formSala(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Sala s = salaService.findOne(id);
		mav.addObject("sala", s);
		mav.addObject("formAction", "editSala");
		mav.setViewName("formSala");
		return mav;
	}
	
	@RequestMapping("/addSala")
	public ModelAndView addSala(@ModelAttribute Sala s){
		ModelAndView mav = new ModelAndView();
		salaService.addSala(s);
		mav.setViewName("redirect:/tablaSala");
		return mav;
	}
	
	@RequestMapping("/editSala")
	public ModelAndView editSala(@ModelAttribute Sala s){
		ModelAndView mav = new ModelAndView();
		salaService.editSala(s);
		mav.setViewName("redirect:/tablaSala");
		return mav;
	}
	
	@RequestMapping("/activarSala")
	public ModelAndView activarSala(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		salaService.activarSala(id);
		mav.setViewName("redirect:/tablaSala");
		return mav;
	}
	
	@RequestMapping(value = "/verSala", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SalaResponse verSala(@RequestParam int id) {
		Sala s = salaService.findOne(id);
		SalaResponse sr = new SalaResponse();
		sr.setCapacidad(s.getCapacidad().toString());
		sr.setNumero(s.getNumero().toString());
		sr.setDescripcion(s.getDescripcion());
		return sr;
	}
}
