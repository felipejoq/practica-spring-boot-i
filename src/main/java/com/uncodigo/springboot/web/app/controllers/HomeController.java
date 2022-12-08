package com.uncodigo.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		//return "redirect:/app"; -> Resetea la petición cambiando la url donde hace get.
		return "forward:/app"; // -> Solo cambia la vista, solo rutas internas.
	}
	
}
