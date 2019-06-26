package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dto.UsuarioDTO;
import com.uca.capas.service.CiudadService;
import com.uca.capas.service.EstadoService;
import com.uca.capas.service.PaisService;
import com.uca.capas.service.RolService;
import com.uca.capas.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private RolService rolService;
	
	/*@RequestMapping("/tablaUsuario")
	public ModelAndView tablaUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuarios", usuarioService.findAll());
		mav.setViewName("tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/formAddUsuario")
	public ModelAndView formUsuario(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new UsuarioDTO());
		mav.addObject("paises", paisService.findAll());
		mav.addObject("estados", estadoService.findAll());
		mav.addObject("ciudades", ciudadService.findAll());
		mav.addObject("roles", rolService.findAll());
		mav.addObject("formAction", "addUsuario");
		mav.setViewName("formUsuario");
		return mav;
	}
	
	@RequestMapping("/formEditUsuario")
	public ModelAndView formUsuario(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		UsuarioDTO dto = usuarioService.findOneDTO(id);
		mav.addObject("usuario", dto);
		mav.addObject("paises", paisService.findAll());
		mav.addObject("estados", estadoService.findAll());
		mav.addObject("ciudades", ciudadService.findAll());
		mav.addObject("roles", rolService.findAll());
		mav.addObject("formAction", "editUsuario");
		mav.setViewName("formUsuario");
		return mav;
	}
	
	@RequestMapping("/addUsuario")
	public ModelAndView addUsuario(@ModelAttribute UsuarioDTO dto){
		ModelAndView mav = new ModelAndView();
		usuarioService.addUsuario(dto);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/editUsuario")
	public ModelAndView editUsuario(@ModelAttribute UsuarioDTO dto){
		ModelAndView mav = new ModelAndView();
		usuarioService.editUsuario(dto);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/activarUsuario")
	public ModelAndView activarUsuario(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		usuarioService.activarUsuario(id);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}*/
}
