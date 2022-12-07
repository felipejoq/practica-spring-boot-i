package com.uncodigo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo", "Envíar parámetros en la Ruta, con rutas variables con @PathVariable");
		
		return "variables/index";
	}

	@GetMapping("/string/{texto}")
	public String variable(@PathVariable String texto, Model model) {
		
		model.addAttribute("titulo", "Recibir params de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El saludo enviado es: " + texto);
		
				
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variable(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("titulo", "Recibir params de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El saludo enviado es: " + texto + " y el número enviado en el path es: " + numero);
		
				
		return "variables/ver";
	}
	
}
