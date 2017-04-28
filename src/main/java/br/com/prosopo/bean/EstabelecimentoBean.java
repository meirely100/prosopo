package br.com.prosopo.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.prosopo.dao.EstabelecimentoDAO;
import br.com.prosopo.entity.ContaReceber;
import br.com.prosopo.entity.Estabelecimento;

@ManagedBean(name = "mBeanEstabelecimento")
@SessionScoped
public class EstabelecimentoBean {

	private Estabelecimento est = new Estabelecimento();
	private List<Estabelecimento> ests = new ArrayList<Estabelecimento>();
	private String nomeFantasia;

	EstabelecimentoDAO estDao = new EstabelecimentoDAO();

	@PostConstruct
	public void init() {
		listar();
		if (ests == null) {
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro
			// cadastrado!",""));
		}
	}

	public List<Estabelecimento> getEsts() {
		return ests;
	}

	public void setEsts(List<Estabelecimento> ests) {
		this.ests = ests;
	}

	private void listar() {
		ests = estDao.ListarEst("");
	}

	/*
	 * public void Salvar(){
	 * 
	 * estDao.Salvar(est); if(est.getIdEstabelecimento() != 0){ //
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo alterado com sucesso!",
	 * "")); }else{ // FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Novo cargo salvo com sucesso!",
	 * "")); } limpar(); listar(); }
	 */

	public void salvar() {
		try {
			if (est.getCaminho() == null) {
				System.out.println("O campo foto é obrigatório");
				return;
			}

			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			Estabelecimento estabelecimentoRetorno = estabelecimentoDAO.merge(est);

			Path origem = Paths.get(est.getCaminho());
			Path destino = Paths.get("C:/development/Upload/" + estabelecimentoRetorno.getIdEstabelecimento() + ".png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

			System.out.println("Produto salvo com sucesso");
		} catch (RuntimeException | IOException erro) {
			System.out.println("Ocorreu um erro ao tentar salvar o produto");
			erro.printStackTrace();
		}
	}

	public Estabelecimento editar(Estabelecimento e) {
		return est = e;
	}

	
	 public void excluir(Estabelecimento e){
	  estDao.excluir(e);
	 
	 
	 
	 
	 limpar(); listar();
	 
	  }
	 
   /*
	public void excluir(Estabelecimento e) {
		
		
		try {
			
			estDao.excluir(e);
			Path arquivo = Paths.get("C:/development//Upload/" + est.getIdEstabelecimento() + ".png");
			Files.deleteIfExists(arquivo);

			limpar();
			listar();

			System.out.println("Produto removido com sucesso");
		} catch (RuntimeException | IOException erro) {
			System.out.println("Ocorreu um erro ao tentar remover o estabelecimento");
			erro.printStackTrace();
		}
	}
	*/

	public void limpar() {
		est = new Estabelecimento();
		ests = new ArrayList<Estabelecimento>();
	}

	public void uploadLogo(FileUploadEvent evento) {

		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
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
