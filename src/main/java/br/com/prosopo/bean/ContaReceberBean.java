package br.com.prosopo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prosopo.dao.ContaReceberDAO;
import br.com.prosopo.entity.ContaReceber;

@ManagedBean (name="mBeanContaReceber")
@SessionScoped
public class ContaReceberBean {

	private ContaReceber contaR = new ContaReceber();
	private List<ContaReceber> contasR = new ArrayList<ContaReceber>() ;
	private String nome;
	
	ContaReceberDAO contaRDAO = new ContaReceberDAO();
	
	
	@PostConstruct
	public void init() {
		listar();
		if(contasR == null){
           //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!",""));
		}
	}
	
	private void listar() {
		contasR = contaRDAO.ListarContaR("");
	}
	
	
	public void Salvar(){

		contaRDAO.Salvar(contaR);
		if(contaR.getIdcontaReceber() != 0){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo alterado com sucesso!", ""));
		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo cargo salvo com sucesso!", ""));
		}
		listar();
	}

	
	public ContaReceber editar(ContaReceber cr){
		return contaR = cr;
	}
	
	public void excluir(ContaReceber cr){
		contaRDAO.excluir(cr);
		listar();
		// listar contas
	}
	
	
	
	//GET SET

	public ContaReceber getContaR() {
		return contaR;
	}

	public void setContaR(ContaReceber contaR) {
		this.contaR = contaR;
	}

	public List<ContaReceber> getContasR() {
		return contasR;
	}

	public void setContasR(List<ContaReceber> contasR) {
		this.contasR = contasR;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContaReceberDAO getContaRDAO() {
		return contaRDAO;
	}

	public void setContaRDAO(ContaReceberDAO contaRDAO) {
		this.contaRDAO = contaRDAO;
	}
	
	
	
	
	
	
	
}
