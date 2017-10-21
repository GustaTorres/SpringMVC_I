package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.model.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public UserDetails loadUserByUsername(String email){
		
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail", Usuario.class);
		query.setParameter("pEmail", email);
		
		Usuario usuario = query.getSingleResult();
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return usuario;
	}


}
