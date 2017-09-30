package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.CarrinhoItem;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoComprasController {
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipo){
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
		carrinhoCompras.add(carrinhoItem);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
		carrinhoCompras.remover(produtoId, tipoPreco);
	    return new ModelAndView("redirect:/carrinho");
	}

	private CarrinhoItem criaItem(Integer produtdoId, TipoPreco tipo) {
		Produto produto = produtoDAO.find(produtdoId);
		
		return new CarrinhoItem(produto, tipo);
	}

}
