package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.prosopo.entity.ContaPagar;

public class ContaPagarDAO {

	private EntityManager manager;

	// Metodo Salvar

	public void Salvar(ContaPagar contaP) {

		EntityManager em = Conexao.getEntityManager();
		try {
			em.getTransaction().begin();

			if (contaP.getIdcontaPagar() == null) {
				em.persist(contaP);
			} else {
				em.merge(contaP);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}

	// Lisar Contas a pagar

	@SuppressWarnings("unchecked")
	public List<ContaPagar> ListarContaP(String titulo) {

		EntityManager em = Conexao.getEntityManager();
		Query query = (Query) em
				.createQuery("select a from ContaPagar a where a.titulo like ? order by a.titulo");
		query.setParameter(1, "%" + titulo + "%");
		return query.getResultList();
	}
	
	//Excluir conta a pagar 
	public void excluir(ContaPagar excluirContaP) {

		try{
			EntityManager em = Conexao.getEntityManager();
			if(excluirContaP != null){
				em.getTransaction().begin();// Inicia uma transação com o banco de dados.
				em.remove(em.getReference(ContaPagar.class, excluirContaP.getIdcontaPagar()));
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
	
	public ContaPagar porId(Long idcontaPagar) {
		return manager.find(ContaPagar.class, idcontaPagar);  //  Verificar !!
	}
	
	public ContaPagar buscarNome(String titulo) {

		EntityManager em = Conexao.getEntityManager();

		Query query = (Query) em.createQuery("select a from ContaPagar a where a.titulo like ? ");
		query.setParameter(1, "%" + titulo + "%");
		if(query.getResultList() != null){
			return (ContaPagar) query.getResultList();
		}else{
			return null;
		}

	}

}
