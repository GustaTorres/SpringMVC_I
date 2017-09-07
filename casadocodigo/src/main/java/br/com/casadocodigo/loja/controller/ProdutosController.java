package br.com.casadocodigo.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("form")
	public ModelAndView form(){		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos",TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String gravar(Produto produto){
		dao.gravar(produto);
		System.out.println(produto);
		return "ok";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listProducts(){
		List<Produto> products = dao.listProducts();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", products);
		return modelAndView;
	}

}
