package br.com.prosopo.bean;

import java.io.IOException;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prosopo.dao.ContaPagarDAO;
import br.com.prosopo.entity.ContaPagar;

@ManagedBean(name="mBeanContaPagar")
@ViewScoped
public class ContaPagarBean {

	
	private ContaPagar contaP = new ContaPagar();
    private List<ContaPagar> contasP ;
  
    
  

	ContaPagarDAO contaPDao = new ContaPagarDAO();
	@PostConstruct
	public void init() {
		listar();
		if(contasP == null){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!",""));
		}
	}
	
	private void listar() {
		contasP = contaPDao.ListarContaP("");
	}
	
	

	public void Salvar(){

		contaPDao.Salvar(contaP);
		if(contaP.getIdcontaPagar() != 0){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo alterado com sucesso!", ""));
		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo cargo salvo com sucesso!", ""));
		}
	}
	
	public ContaPagar editar(ContaPagar cp){
		return contaP = cp;
	}
	
	public void excluir(ContaPagar cp){
		contaPDao.excluir(cp);
		listar();// listar cargos
	}
	  
	public ContaPagar getContaP() {
		return contaP;
	}

	public List<ContaPagar> getContasP() {
		return contasP;
	}

	public void setContasP(List<ContaPagar> contasP) {
		this.contasP = contasP;
	}

	public void setContaP(ContaPagar contaP) {
		this.contaP = contaP;
	}
	
}
