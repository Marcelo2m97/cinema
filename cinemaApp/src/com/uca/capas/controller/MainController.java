package com.uca.capas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/administracion")
	public ModelAndView administracion() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("administracion");
		return mav;
	}
}
