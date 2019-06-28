package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.CiudadService;
import com.uca.capas.service.EstadoService;
import com.uca.capas.service.PaisService;
import com.uca.capas.service.RolService;
import com.uca.capas.service.UsuarioService;

import javassist.tools.rmi.ObjectNotFoundException;

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
	
	@RequestMapping("/tablaUsuario")
	public ModelAndView tablaUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuarios", usuarioService.findAll());
		mav.setViewName("tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.addObject("paises", paisService.findAll());
		mav.addObject("estados", estadoService.findAll());
		mav.addObject("ciudades", ciudadService.findAll());
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping("/formAddUsuario")
	public ModelAndView formUsuario(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.addObject("paises", paisService.findAll());
		mav.addObject("estados", estadoService.findAll());
		mav.addObject("ciudades", ciudadService.findAll());
		try {
			mav.addObject("roles", rolService.findAll());
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		mav.addObject("formAction", "addUsuario");
		mav.setViewName("formUsuario");
		return mav;
	}
	
	@RequestMapping("/formEditUsuario")
	public ModelAndView formUsuario(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Usuario u = usuarioService.findOne(id);
		mav.addObject("usuario", u);
		mav.addObject("paises", paisService.findAll());
		mav.addObject("estados", estadoService.findAll());
		mav.addObject("ciudades", ciudadService.findAll());
		try {
			mav.addObject("roles", rolService.findAll());
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		mav.addObject("formAction", "editUsuario");
		mav.setViewName("formUsuarioEdit");
		return mav;
	}
	
	@RequestMapping("/addUsuario")
	public ModelAndView addUsuario(@ModelAttribute Usuario u){
		ModelAndView mav = new ModelAndView();
		usuarioService.addUsuario(u);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/addUsuarioRegister")
	public ModelAndView addUsuarioRegister(@ModelAttribute Usuario u){
		ModelAndView mav = new ModelAndView();
		usuarioService.registerUsuario(u);
		mav.setViewName("redirect:/login");
		return mav;
	}
	
	@RequestMapping("/editUsuario")
	public ModelAndView editUsuario(@ModelAttribute Usuario u){
		ModelAndView mav = new ModelAndView();
		usuarioService.editUsuario(u);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}
	
	@RequestMapping("/activarUsuario")
	public ModelAndView activarUsuario(@RequestParam int id, String motivo){
		ModelAndView mav = new ModelAndView();
		usuarioService.activarUsuario(id, motivo);
		mav.setViewName("redirect:/tablaUsuario");
		return mav;
	}
}
