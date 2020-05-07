package com.topicos.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String descricao;
	private double preco;
	
}
