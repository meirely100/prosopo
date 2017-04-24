package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.ResponsavelFinanceiro;


public class ResponsavelFinanceiroDao {

	private EntityManager em;

	public void salvar(ResponsavelFinanceiro resp) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (resp.getIdResponsavel() == null) {
				em.persist(resp);
			} else {
				em.merge(resp);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ResponsavelFinanceiro> listarResponsavel(String busca) {
		em = Conexao.getEntityManager();
		String consulta = "select r from ResponsavelFinanceiro r where r.nome like :busca order by r.nome";
		TypedQuery<ResponsavelFinanceiro> query = em.createQuery(consulta, ResponsavelFinanceiro.class);
		query.setParameter("busca", "%" + busca + "%");
		List<ResponsavelFinanceiro> resultado = query.getResultList();
		return resultado;
	}

	public ResponsavelFinanceiro buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		ResponsavelFinanceiro func = em.find(ResponsavelFinanceiro.class, id);
		em.close();
		return func;
	}
}
