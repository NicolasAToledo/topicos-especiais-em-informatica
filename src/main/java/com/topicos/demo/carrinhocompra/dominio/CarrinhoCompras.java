package com.topicos.demo.carrinhocompra.dominio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.topicos.demo.produto.dominio.Produto;

import lombok.Getter;

@Getter

@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class CarrinhoCompras {
	
	private List<Produto> produtosCarrinho = new ArrayList<>();
	
	public void addProduto(Produto produto) {
		this.produtosCarrinho.add(produto);
	}
	
	public void limparCarrinho() {
		this.produtosCarrinho.clear();
	}
	
	public void removeProduto(Produto produto) {
		this.produtosCarrinho.remove(produto);
	}
}
