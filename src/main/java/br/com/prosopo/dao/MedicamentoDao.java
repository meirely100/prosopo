package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.Medicamento;
import br.com.prosopo.entity.ResponsavelFinanceiro;

public class MedicamentoDao {

	private EntityManager em;

	public void salvar(Medicamento med) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try {
			if (med.getIdMedicamento() == null) {
				em.persist(med);
			} else {
				em.merge(med);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Medicamento> listarMedicamentos(String busca) {
		em = Conexao.getEntityManager();
		try {
			String consulta = "select med from Medicamento med where med.nomeMedicamento like :busca order by med.nomeMedicamento";
			TypedQuery<Medicamento> query = em.createQuery(consulta, Medicamento.class);
			query.setParameter("busca", "%" + busca + "%");
			List<Medicamento> resultado = query.getResultList();
			return resultado;
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			return null;
		}

	}

	public Medicamento buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		Medicamento med = em.find(Medicamento.class, id);
		em.close();
		return med;
	}

	public void excluir(Medicamento excluirMed) {

		try {
			em = Conexao.getEntityManager();
			if (excluirMed != null) {
				em.getTransaction().begin();// Inicia uma transação com o banco
											// de dados.
				em.remove(em.getReference(Medicamento.class, excluirMed.getIdMedicamento()));
				em.getTransaction().commit();// Finaliza a transação.
				em.close();
			} else {
				System.out.println("sem registro");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
