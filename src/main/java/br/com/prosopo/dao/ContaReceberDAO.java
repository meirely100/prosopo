package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.entity.ContaReceber;

public class ContaReceberDAO {
	
	
	
	private EntityManager manager;

	public void Salvar(ContaReceber cr) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (cr.getIdcontaReceber() == null) {
				em.persist(cr);
			} else {
				em.merge(cr);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaReceber> ListarContaR(String titulo) {
		EntityManager em = Conexao.getEntityManager();
		Query query = (Query) em.createQuery("select a from ContaReceber a where a.titulo like ? order by a.titulo");
		query.setParameter(1, "%" + titulo + "%");
		return query.getResultList();
	}
	
	public void excluir(ContaReceber excluirContaR) {

		try{
			EntityManager em = Conexao.getEntityManager();
			if(excluirContaR != null){
				em.getTransaction().begin();// Inicia uma transação com o banco de dados.
				em.remove(em.getReference(ContaReceber.class, excluirContaR.getIdcontaReceber()));
				em.getTransaction().commit();// Finaliza a transação.
				em.close();
			}
			else{
				System.out.println("sem registro");
			}
		} catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
				
	}
	
	
	public ContaReceber porId(Long idContaReceber) {
		return manager.find(ContaReceber.class, idContaReceber);
	}
	
	public ContaReceber buscarNome(String titulo) {

		EntityManager em = Conexao.getEntityManager();

		Query query = (Query) em.createQuery("select a from ContaRecber a where a.titulo like ? ");
		query.setParameter(1, "%" + titulo + "%");
		if(query.getResultList() != null){
			return (ContaReceber) query.getResultList();
		}else{
			return null;
		}

	}
	

}
