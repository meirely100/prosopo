package br.com.prosopo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.prosopo.dao.ResponsavelFinanceiroDao;
import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;
import br.com.prosopo.entity.ResponsavelFinanceiro;

@ManagedBean(name = "mBeanResponsavel")
@SessionScoped
public class ResponsavelBean {
	
	private ResponsavelFinanceiro rf = new ResponsavelFinanceiro();
	private List<ResponsavelFinanceiro> listRespFin;
	private ResponsavelFinanceiroDao rfDao = new ResponsavelFinanceiroDao();
	
	@PostConstruct
	public void init() {
		listRespFin = new ArrayList<ResponsavelFinanceiro>();
		listRespFin = rfDao.listarResponsavel("");
		}
	
	public String salvar(){
		try{
			rf = new ResponsavelFinanceiro();
			rfDao.salvar(rf);
			return "listResponsavel.jsf";
		
	} catch (Exception ef) {
		FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Erro ao tentar salvar! Verifique dados do cadastro"));
		System.out.println("erro: " + ef.getMessage());
		return "funcionario.jsf";

	}
	}
	
	//getts e setts
	public ResponsavelFinanceiro getRf() {
		return rf;
	}
	public void setRf(ResponsavelFinanceiro rf) {
		this.rf = rf;
	}
	public List<ResponsavelFinanceiro> getListRespFin() {
		return listRespFin;
	}
	public void setListRespFin(List<ResponsavelFinanceiro> listRespFin) {
		this.listRespFin = listRespFin;
	}
	

}
