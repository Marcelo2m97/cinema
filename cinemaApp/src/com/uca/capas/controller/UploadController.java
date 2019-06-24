package com.uca.capas.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/formUpload")
	public ModelAndView uploadForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("formUpload");
		return mav;
	}

	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> it = request.getFileNames();
		MultipartFile mpf = null;
		while (it.hasNext()) {
			mpf = request.getFile(it.next());
			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(context.getRealPath("/resources")+"/"+mpf.getOriginalFilename().replace(" ", "-")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mpf.getOriginalFilename().replace(" ", "-");
	}
}
