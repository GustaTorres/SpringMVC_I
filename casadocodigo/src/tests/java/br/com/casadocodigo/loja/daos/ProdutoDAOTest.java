package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class,ProdutoDAO.class})
public class ProdutoDAOTest {

	@Autowired
	private ProdutoDAO dao;
	
	@Transactional
	@Test
	public void shouldSumAllPricesByTypeBook() {
		
		
		List<Produto> booksPritend = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(3).buildAll();
		List<Produto> booksEbook= ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(3).buildAll();
		
		booksPritend.stream().forEach(dao::gravar);
		booksEbook.stream().forEach(dao::gravar);
		
		BigDecimal valor = dao.somaPrecosPorTipo(TipoPreco.IMPRESSO);

		Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
		
		
	}
	
}

