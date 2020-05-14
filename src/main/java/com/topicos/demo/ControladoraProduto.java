package com.topicos.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladoraProduto {

	@GetMapping("/testando")//Duas formas de receber dados | @RequestParam("id")Long id, 
	public ModelAndView metodoTeste(Produto produto) {
		System.out.println(produto.getId()+produto.getNome()+produto.getDescricao()+produto.getPreco());
		ModelAndView modelAndView = new ModelAndView("paginaTeste");
		modelAndView.addObject("produtoVariavel", produto);
		return modelAndView;	
	}
}
