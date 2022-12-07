package com.uncodigo.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uncodigo.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {

		// model.addAttribute("titulo", "Hola :) !!");
		// map.put("titulo", "Hola :) !!");

		// mv.addObject("titulo", "Hola :) !!");
		// mv.setViewName("index");

		model.addAttribute("titulo", textoIndex);
		model.addAttribute("subTitulo", "Hola mundo! :) AZUL!");

		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Felipe");
		usuario.setApellido("Jofre");
		usuario.setEmail("test@test.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoPerfil);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Felipe", "Jofre", "test@test.com"),
				new Usuario("Angelica", "Romero", "test@test.com"),
				new Usuario("Jhon", "Aragon"),
				new Usuario("Antonio", "Raven"));
		
		return usuarios;
	}

}
