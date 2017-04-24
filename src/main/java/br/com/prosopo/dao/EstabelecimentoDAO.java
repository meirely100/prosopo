package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.entity.Estabelecimento;

public class EstabelecimentoDAO {

	private EntityManager manager;

	// Metodo Salvar

	public void Salvar(Estabelecimento est) {

		EntityManager em = Conexao.getEntityManager();
		try {
			em.getTransaction().begin();

			if (est.getIdEstabelecimento() == null) {
				em.persist(est);
			} else {
				em.merge(est);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estabelecimento> ListarEst(String nomeFantasia) {

		EntityManager em = Conexao.getEntityManager();
		Query query = (Query) em
				.createQuery("select a from Estabelecimento a where a.nomeFanasia like ? order by a.nomeFantasia");
		query.setParameter(1, "%" + nomeFantasia + "%");
		return query.getResultList();
	}
	
	
	//Excluir estabelecimento 
		public void excluir(Estabelecimento excluirEst) {

			try{
				EntityManager em = Conexao.getEntityManager();
				if(excluirEst != null){
					em.getTransaction().begin();// Inicia uma transação com o banco de dados.
					em.remove(em.getReference(Estabelecimento.class, excluirEst.getIdEstabelecimento()));
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
		
		
		
	
	
}
