package br.com.casadocodigo.loja.controller;

import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validation.ProductValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO dao;

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProductValidation());
	}

	@RequestMapping("form")
	public ModelAndView form(Produto produto){		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos",TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)

	public ModelAndView gravar(@Valid Produto produto,BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			return form(produto);
		}		

		dao.gravar(produto);
		System.out.println(produto);
		
		attributes.addFlashAttribute("sucesso", "Livro cadastrado com sucesso!");
		
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listProducts(){
		List<Produto> products = dao.listProducts();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", products);
		return modelAndView;
	}

}
