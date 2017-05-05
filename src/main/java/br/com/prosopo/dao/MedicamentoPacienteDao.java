package br.com.prosopo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.prosopo.entity.MedicamentoPaciente;

public class MedicamentoPacienteDao {

	private EntityManager em;

	public void salvar(MedicamentoPaciente med) {
		em = Conexao.getEntityManager();
		em.getTransaction().begin();
		try {
			if (med.getIdMedPaciente() == null) {
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
	public List<MedicamentoPaciente> listarMedicamentos(Long codigoPaciente) {
		em = Conexao.getEntityManager();
		try {
			String consulta = "select med from MedicamentoPaciente med where med.FkPaciente.idPaciente like :codigoPaciente order by med.MedicamentoPaciente.nomeMedicamento";
			TypedQuery<MedicamentoPaciente> query = em.createQuery(consulta, MedicamentoPaciente.class);
			query.setParameter("codigoPaciente", codigoPaciente);
			List<MedicamentoPaciente> resultado = query.getResultList();
			return resultado;
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			return null;
		}
	}

	public MedicamentoPaciente buscaPorId(Long id) {
		em = Conexao.getEntityManager();
		MedicamentoPaciente med = em.find(MedicamentoPaciente.class, id);
		em.close();
		return med;
	}


	
}
