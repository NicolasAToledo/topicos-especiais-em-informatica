package com.topicos.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladoraProduto {

	@GetMapping("/testando")
	public String metodoTeste() {
		System.out.println("Passei aqui!!!");
		return "paginaTeste";	
	}
}
