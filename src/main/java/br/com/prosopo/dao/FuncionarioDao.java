package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.bean.Funcionario;

public class FuncionarioDao {
	
	private EntityManager manager;

	public void Salvar(Funcionario f) {
		EntityManager em = Conexao.getEntityManager();
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
	public List<Funcionario> ListarFuncionarios(String nome) {
		EntityManager em = Conexao.getEntityManager();
		Query query = (Query) em.createQuery("Select f from Funcionario f where f.nome like ? order by a.nome");
		query.setParameter(1, "%" + nome + "%");
		return query.getResultList();
	}


}
