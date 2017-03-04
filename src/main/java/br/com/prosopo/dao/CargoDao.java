package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prosopo.entity.Cargo;


public class CargoDao {

	private EntityManager manager;

	public void Salvar(Cargo c) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (c.getIdCargo() == null) {
				em.persist(c);
			} else {
				em.merge(c);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> ListarCargo() {
		EntityManager em = Conexao.getEntityManager();

		Query query = (Query) em.createQuery("from Cargo");

		return query.getResultList();
	}

	public void excluir(Long id) {

		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();// Inicia uma transação com o banco de
		// dados.
		Cargo cargo = em.find(Cargo.class, id);// Consulta cargo na base de
		// dados através do seu ID.
		em.remove(cargo); // Remove.
		em.getTransaction().commit();// Finaliza a transação.
		em.close();
	}

	public Cargo porId(Long id) {
		return manager.find(Cargo.class, id);
	}

	public Cargo buscarNome(String nome) {

		EntityManager em = Conexao.getEntityManager();

		Query query = (Query) em.createQuery("select a from Cargo a where a.cargo like ? ");
		query.setParameter(1, "%" + nome + "%");
		if(query.getResultList() != null){
			return (Cargo) query.getResultList();
		}else{
			return null;
		}

	}

}
