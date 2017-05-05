package br.com.prosopo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prosopo.dao.MedicamentoDao;
import br.com.prosopo.entity.Medicamento;

@ManagedBean(name = "mBeanMedicamento")
@SessionScoped
public class MedicamentoBean {

	private Medicamento med = new Medicamento();
	private MedicamentoDao medDao = new MedicamentoDao();

	private Long idMed;
	private List<Medicamento> listMed;

	@PostConstruct
	public void init() {
		listar();
		if (listMed == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!", ""));
		}
	}

	public String salvar() {
		try {
			medDao.salvar(med);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Salvo com sucesso!"));
			listar();
			return "listMedicamento.jsf";

		} catch (Exception erroSalvar) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
					"Erro ao tentar salvar! Verifique dados do cadastro"));
			System.out.println("erro: " + erroSalvar.getMessage());
			return "medicamento.jsf";
		}
	}

	public String editar(Medicamento medEditar) {
		try {
			med = new Medicamento();
			med = medEditar;
			return "medicamento.jsf";
		} catch (Exception erroEditar) {
			System.out.println("erro: " + erroEditar.getMessage());
			return "listMedicamento.jsf";
		}
	}

	public void excluir(Medicamento medExcluir) {
		try {
			medDao.excluir(medExcluir);
			listMed = new MedicamentoDao().listarMedicamentos("");
			//return "listMedicamento.jsf";
		} catch (Exception erroExcluir) {
			System.out.println("erro: " + erroExcluir.getMessage());
			//return null;
		}
	}

	public void listar() {
		listMed = new ArrayList<Medicamento>();
		listMed = medDao.listarMedicamentos("");
	}

	public void limpar() {
		med = new Medicamento();
		listMed = new ArrayList<Medicamento>();
	}

	public Medicamento getMed() {
		return med;
	}

	public void setMed(Medicamento med) {
		this.med = med;
	}

	public MedicamentoDao getMedDao() {
		return medDao;
	}

	public void setMedDao(MedicamentoDao medDao) {
		this.medDao = medDao;
	}

	public Long getIdMed() {
		return idMed;
	}

	public void setIdMed(Long idMed) {
		this.idMed = idMed;
	}

	public List<Medicamento> getListMed() {
		return listMed;
	}

	public void setListMed(List<Medicamento> listMed) {
		this.listMed = listMed;
	}

}
