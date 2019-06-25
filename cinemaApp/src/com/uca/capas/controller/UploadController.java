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

@Controller
public class UploadController {
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public @ResponseBody String uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {
		MultipartFile mpf = request.getFile("file");
		try {
			FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(context.getRealPath("/resources")+"/"+mpf.getOriginalFilename().replace(" ", "-")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mpf.getOriginalFilename().replace(" ", "-");
	}

	@RequestMapping(value="/uploadFiles", method=RequestMethod.POST)
	public @ResponseBody String uploadMultiple(MultipartHttpServletRequest request, HttpServletResponse response) {
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
