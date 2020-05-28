package com.topicos.demo.produto.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicos.demo.produto.dominio.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
