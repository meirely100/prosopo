package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public List<Funcionario> listarFuncionarios(String busca) {
		em = Conexao.getEntityManager();
		String consulta = "select f from Funcionario f where f.nome like :busca order by f.nome";
		//Query query = (Query) em.createQuery("select * from Funcionario f where f.nome like :busca");
		TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
		query.setParameter("busca", "%" + busca + "%");
		List<Funcionario> resultado = query.getResultList();
		return resultado;
		//return query.getResultList();
	}

	public Funcionario buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		Funcionario func = em.find(Funcionario.class, id);
		em.close();
		return func;
		//return em.find(Funcionario.class, id);
	}
}
