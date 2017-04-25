package br.com.prosopo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.prosopo.dao.ConvenioDao;
import br.com.prosopo.entity.Convenio;
@ManagedBean(name="mBeanConvenio")
@SessionScoped
public class ConvenioBean {

	private Convenio conv = new Convenio();
	private ConvenioDao convDao = new ConvenioDao();
	private List<Convenio> listConv;
	
	@PostConstruct
	public void init() {
		listar();
		conv.setStatus(true);
		if(listConv == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!",""));
		}
	}
	
	public String salvar(){
		try{
			convDao.salvar(conv);
			FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!", "Salvo com sucesso!"));
			listar();
			System.out.println(conv.getValorRepasse());
			return "listConvenio.jsf";
		}catch (Exception erroSalvar){
			FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Erro ao tentar salvar! Verifique dados do cadastro"));
			System.out.println("erro: " + erroSalvar.getMessage());
			return "convenio.jsf";
		}
		
	}
	
	public void listar(){
		listConv = new ArrayList<Convenio>();
		listConv = convDao.listarConvenios("");
	}
	
	public String editar (Convenio convEditar){
		try{
			conv = new Convenio();
			conv = convEditar;
			return "convenio.jsf";
		}
		catch(Exception edt){
			conv = new Convenio();
			conv = convEditar;
			return "listConvenio.jsf";
		}
		
	}
	
	public Convenio getConv() {
		return conv;
	}
	public void setConv(Convenio conv) {
		this.conv = conv;
	}
	public ConvenioDao getConvDao() {
		return convDao;
	}
	public void setConvDao(ConvenioDao convDao) {
		this.convDao = convDao;
	}
	public List<Convenio> getListConv() {
		return listConv;
	}
	public void setListConv(List<Convenio> listConv) {
		this.listConv = listConv;
	}
	
}
