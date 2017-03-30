package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.entity.Usuario;

public class UsuarioDao {
	
	Usuario user = new Usuario();
	private EntityManager em;
	
	public void salvar(Usuario u){
		em = Conexao.getEntityManager();

		em.getTransaction().begin();

		if (u.getIdUsuario() == null) {
			em.persist(u);
		} else {
			em.merge(u);
		}

		em.getTransaction().commit();
		
	}

	public Usuario validarLogin (Usuario usuario){
		try {
			EntityManager em = Conexao.getEntityManager();
			Query query = (Query) em.createQuery("SELECT u FROM Usuario u where u.login = ? and u.senha = ?");
			query.setParameter(1, usuario.getLogin());
			query.setParameter(2, usuario.getSenha());
			user = new Usuario();
			List<Usuario> us = query.getResultList();
			for (Usuario usuario1 : us) {
				user = usuario1;
			}
			return usuario;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
	
	
}
