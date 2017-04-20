package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.Psicologo;

public class PsicologoDao {
	
	private EntityManager em;

	public void salvar(Psicologo psi) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (psi.getIdPsicologo() == null) {
				em.persist(psi);
			} else {
				em.merge(psi);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Psicologo> listarPsicologos(String busca) {
		em = Conexao.getEntityManager();
		String consulta = "select p from Psicologo p where p.nome like :busca order by p.nome";
		TypedQuery<Psicologo> query = em.createQuery(consulta, Psicologo.class);
		query.setParameter("busca", "%" + busca + "%");
		List<Psicologo> resultado = query.getResultList();
		return resultado;
		//return query.getResultList();
	}

	public Psicologo buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		Psicologo psi = em.find(Psicologo.class, id);
		em.close();
		return psi;
	}
	
	public Psicologo buscaPorCrp(Long crp) {
		em = Conexao.getEntityManager();
		Psicologo psi = em.find(Psicologo.class, crp);
		em.close();
		return psi;
	}

}
