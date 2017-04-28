package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.Convenio;

public class ConvenioDao {
	
	private EntityManager em;

	public void salvar(Convenio conv) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try{
			if (conv.getIdConvenio() == null) {
				em.persist(conv);
			} else {
				em.merge(conv);
			}
			em.getTransaction().commit();
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Convenio> listarConvenios(String busca) {
		em = Conexao.getEntityManager();
		String consulta = "select c from Convenio c where c.razaoSocial like :busca order by c.razaoSocial";
		TypedQuery<Convenio> query = em.createQuery(consulta, Convenio.class);
		query.setParameter("busca", "%" + busca + "%");
		List<Convenio> resultado = query.getResultList();
		return resultado;
	}

	public Convenio buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		Convenio func = em.find(Convenio.class, id);
		em.close();
		return func;
	}

}
