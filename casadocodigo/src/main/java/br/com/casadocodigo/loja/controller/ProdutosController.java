package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/produtos/form")
	public String form(){		
		System.out.println("Retornando form");
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto){
		dao.gravar(produto);
		System.out.println(produto);
		return "ok";
	}

}
