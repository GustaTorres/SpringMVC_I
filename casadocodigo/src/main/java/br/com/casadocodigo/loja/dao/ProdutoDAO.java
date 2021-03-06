package br.com.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void gravar(Produto produto){
		manager.persist(produto);
	}


	public List<Produto> listProducts() {
		TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p",Produto.class);
		return query.getResultList();
	}


	public Produto find(Integer id) {
		TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p JOIN FETCH p.precos WHERE p.id = :pId",Produto.class);
		query.setParameter("pId", id);
		
		return query.getSingleResult();
	}


	public BigDecimal somaPrecosPorTipo(TipoPreco tipo) {
		TypedQuery<BigDecimal> query = manager.createQuery("SELECT SUM(preco.valor) FROM Produto p JOIN p.precos preco WHERE preco.tipo = :pTipo", BigDecimal.class);
		query.setParameter("pTipo", tipo);
		
		return query.getSingleResult();
	}
}
