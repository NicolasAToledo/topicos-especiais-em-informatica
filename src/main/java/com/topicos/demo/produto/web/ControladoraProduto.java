package com.topicos.demo.produto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.topicos.demo.produto.dominio.Produto;
import com.topicos.demo.produto.persistencia.ProdutoRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Controller
@RequestMapping("/produtos")
public class ControladoraProduto {
	
	private final ProdutoRepositorio produtoRepositorio;
	
	@GetMapping
	public ModelAndView listar(@ModelAttribute("produtoEmEdicao") Produto produtoEmEdicao) {
		
		List<Produto> produtos = this.produtoRepositorio.findAll();
		
		ModelAndView modelAndView = new ModelAndView("listar");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;	
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(Produto produto) {
		this.produtoRepositorio.save(produto);
		
		return new ModelAndView("sucessoInsercao");
	}
	
	@GetMapping("/excluir")
	public ModelAndView excluir(@RequestParam("id") Long id) {
		this.produtoRepositorio.deleteById(id);
		
		return new ModelAndView("sucessoExclusao");
	}

	@GetMapping("antesAlterar")
	public ModelAndView antesAlterar(@RequestParam("id") Long id) {
		
		Optional<Produto> produtoOptional = this.produtoRepositorio.findById(id);
		
		if(produtoOptional.isPresent()) {
			ModelAndView modelAndView = new ModelAndView("listar");
			List<Produto> produtos = this.produtoRepositorio.findAll();
			modelAndView.addObject("produtos", produtos);
			modelAndView.addObject("produtoEmEdicao", produtoOptional.get());
			return modelAndView;
		}else {
			return new ModelAndView("naoEncontrado");
		}	
	}
	
	
	//Alterar ficaria assim
	/*
	@GetMapping("/alterar")
	public ModelAndView alterar(Produto produto) {
		this.produtoRepositorio.save(produto);
		
		return new ModelAndView("sucessoAlteracao");
	}
	
	//Teste inicial
	@GetMapping("/testando")//Duas formas de receber dados | @RequestParam("id")Long id, 
	public ModelAndView metodoTeste(Produto produto) {
		System.out.println(produto.getId()+produto.getNome()+produto.getDescricao()+produto.getPreco());
		ModelAndView modelAndView = new ModelAndView("paginaTeste");
		modelAndView.addObject("produtoVariavel", produto);
		return modelAndView;	
	}
	*/
}
