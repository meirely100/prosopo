package br.com.prosopo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prosopo.dao.MedicamentoPacienteDao;
import br.com.prosopo.entity.MedicamentoPaciente;

@ManagedBean(name = "mBeanMedPaciente")
@SessionScoped
public class MedPacienteBean {
	
	private MedicamentoPaciente mp = new MedicamentoPaciente();
	private MedicamentoPacienteDao mpDao = new MedicamentoPacienteDao();
	
	private List<MedicamentoPaciente> listMed;
	private Long idPaciente;
	private Long idMedicamento;
	
	public void salvar(Long id){
		
	}
	
	public MedicamentoPaciente getMp() {
		return mp;
	}
	public void setMp(MedicamentoPaciente mp) {
		this.mp = mp;
	}
	public MedicamentoPacienteDao getMpDao() {
		return mpDao;
	}
	public void setMpDao(MedicamentoPacienteDao mpDao) {
		this.mpDao = mpDao;
	}
	public List<MedicamentoPaciente> getListMed() {
		return listMed;
	}
	public void setListMed(List<MedicamentoPaciente> listMed) {
		this.listMed = listMed;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Long getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	
}
