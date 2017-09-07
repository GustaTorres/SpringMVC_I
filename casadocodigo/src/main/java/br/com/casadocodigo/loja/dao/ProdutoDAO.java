package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.model.Produto;

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

}
