package com.topicos.demo.carrinhocompra.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.topicos.demo.carrinhocompra.dominio.CarrinhoCompras;
import com.topicos.demo.produto.dominio.Produto;
import com.topicos.demo.produto.persistencia.ProdutoRepositorio;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasControladora {

	private final CarrinhoCompras carrinhoCompras;
	private final ProdutoRepositorio produtoRepositorio;
	
	@GetMapping
	public ModelAndView exibirCarrinho() {
		
		ModelAndView modelAndView = new ModelAndView("carrinhoCompras");
		modelAndView.addObject("carrinho", carrinhoCompras);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView adicionarProduto(@RequestParam("id") Long id) {
		
		ModelAndView modelAndView = new ModelAndView("carrinhoCompras");
		
		Optional<Produto> produtoOptional = produtoRepositorio.findById(id);
		
		if(produtoOptional.isPresent()) {
			carrinhoCompras.addProduto(produtoOptional.get());
		}else {
			modelAndView.addObject("erro", true);
		}
		
		modelAndView.addObject("carrinho", carrinhoCompras);
		modelAndView.addObject("total", carrinhoCompras.getTotal());
		modelAndView.addObject("totalItems", carrinhoCompras.size());
		
		return modelAndView;
	}
}
