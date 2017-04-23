package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;


public class CargoDao {

	private EntityManager em;
	
	public void salvar(Cargo c) {
		em = Conexao.getEntityManager();
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
	public List<Cargo> listarCargo(String busca) {
		em = Conexao.getEntityManager();
		String consulta = "select c from Cargo c where c.cargo like :busca order by c.cargo";
		TypedQuery<Cargo> query = em.createQuery(consulta, Cargo.class);
		query.setParameter("busca", "%" + busca + "%");
		List<Cargo> resultado = query.getResultList();
		return resultado;
//		Query query = (Query) em.createQuery("select c from Cargo c where c.cargo like ? order by c.cargo");
//		query.setParameter(1, "%" + busca + "%");
//		return query.getResultList();
	}

	public void excluir(Cargo excluirCargo) {

		try{
			em = Conexao.getEntityManager();
			if(excluirCargo != null){
				em.getTransaction().begin();// Inicia uma transação com o banco de dados.
				em.remove(em.getReference(Cargo.class, excluirCargo.getIdCargo()));
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

	public Cargo buscaPorNome(String nome) {

		em = Conexao.getEntityManager();
		String consulta = "select c from Cargo c where c.cargo = :nome";
		Query query = em.createQuery(consulta, Cargo.class);
		query.setParameter("nome", nome);
		Cargo busca = (Cargo) query.getSingleResult();
		em.close();
		return busca;
	}
	
	public Cargo buscaPorId(Long id){
		em = Conexao.getEntityManager();
		Query query = (Query) em.createQuery("select c from Cargo c where c.idCargo = ?  ");
		((javax.persistence.Query) query).setParameter(1, id);
		return (Cargo) query.getSingleResult();
	}

}
