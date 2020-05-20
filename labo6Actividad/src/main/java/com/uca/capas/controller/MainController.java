package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	Logger log = Logger.getLogger(MainController.class.getName());
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/inicio")	
	public ModelAndView initMain() {	
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	

	@RequestMapping("/ingresarEstudiante")
	public ModelAndView ingresarEstudiante(@Valid  @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { 
			mav.setViewName("index");
		}else {	
		estudianteDAO.insertar(estudiante);
		mav.setViewName("index");
		}
		return mav;
	}

		
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/eliminarEstudiante")
	public ModelAndView delete(@RequestParam(value="c") Integer c) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteDAO.eliminar(c);
			log.info("Eliminado");
		}
		catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		estudiantes = estudianteDAO.findAll();
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
}