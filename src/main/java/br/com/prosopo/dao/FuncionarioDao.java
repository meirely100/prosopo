package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;

public class FuncionarioDao {
	
	private EntityManager em;

	public void salvar(Funcionario f) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (f.getIdFuncionario() == null) {
				em.persist(f);
			} else {
				em.merge(f);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionarios(String nome) {
		em = Conexao.getEntityManager();
		Query query = (Query) em.createQuery("Select f from Funcionario f where f.nome like ? order by f.nome");
		query.setParameter(1, "%" + nome + "%");
		return query.getResultList();
	}

	public Funcionario buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		return em.find(Funcionario.class, id);
	}
}
