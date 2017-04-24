package br.com.prosopo.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.prosopo.dao.EstabelecimentoDAO;
import br.com.prosopo.entity.Estabelecimento;


@ManagedBean(name="mBeanEstabelecimento")
@SessionScoped
public class EstabelecimentoBean {
	
	
	private Estabelecimento est = new Estabelecimento();
	List<Estabelecimento> ests ;
	private String nomeFantasia;
	
	
	EstabelecimentoDAO estDao = new EstabelecimentoDAO();
	
	@PostConstruct
	public void init() {
		listar();
		if(ests == null){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!",""));
		}
	}
	
	private void listar() {
		ests = estDao.ListarEst("");
	}
	
	
	public void Salvar(){

		estDao.Salvar(est);
		if(est.getIdEstabelecimento() != 0){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo alterado com sucesso!", ""));
		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo cargo salvo com sucesso!", ""));
		}
		limpar();
		listar();
	}
	
	public Estabelecimento editar(Estabelecimento e){
		return est = e;
	}
	
	public void excluir(Estabelecimento e){
		estDao.excluir(e);
		limpar();
		listar();
		// listar cargos
	}
	
	public void limpar(){
		est = new Estabelecimento();
		ests = new ArrayList<Estabelecimento>();
	}
	
	
	public void uploadLogo(FileUploadEvent  evento){
		
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(),arquivoTemp, StandardCopyOption.REPLACE_EXISTING );
			est.setCaminho(arquivoTemp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	public Estabelecimento getEst() {
		return est;
	}



	public void setEst(Estabelecimento est) {
		this.est = est;
	}



	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}

