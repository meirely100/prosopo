package br.com.prosopo.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFileWrapper;

import br.com.prosopo.dao.CargoDao;
import br.com.prosopo.dao.PsicologoDao;
import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Psicologo;

@ManagedBean(name = "mBeanPsicologo")
@SessionScoped
public class PsicologoBean {

	private Psicologo psico = new Psicologo();
	private PsicologoDao psicoDao = new PsicologoDao();

	private CargoDao cDao = new CargoDao();
	private Cargo cargoPsico = new Cargo();
	private List<Psicologo> listPsico;
	private UploadedFileWrapper arquivo;
	private Long idCargo;
	String nomeFoto;

	@PostConstruct
	public void init() {
		listar();
		listPsico = new ArrayList<Psicologo>();
		listPsico = psicoDao.listarPsicologos("");
		cargoPsico = cDao.buscaPorNome("Psicólogo");
	}

	public String salvar() {
		try {
			cargoPsico = cDao.buscaPorNome(cargoPsico.getCargo());
			psico.setCargoPsico(cargoPsico);
			Date dataDem = psico.getDataDemissao();
			if (dataDem == null) {
				psico.setStatus("ativo");
			} else if (dataDem != null) {

				psico.setStatus("inativo");
			}
			psicoDao.salvar(psico);

			if (nomeFoto == null || nomeFoto == "") {
				nomeFoto = arquivo.getFileName();
			}
			String pegarCaminho = psico.getCaminhoFoto();
			String testeArq = arquivo.getFileName();
			if (nomeFoto != null && pegarCaminho == null) {
				// chamando metodo para salvar foto, caso o usuário não tenha
				// foto ou seja novo usuário
				imagem();
				psicoDao.salvar(psico);
			} else if (!(nomeFoto == null) && !(nomeFoto == pegarCaminho)) {
				if (testeArq.hashCode() == 0) {

				} else {
					// apago a imagem do diretorio
					File file = new File(pegarCaminho);
					file.delete();
					// chamo novamente o metodo para salvar a nova imagem
					// inserida
					imagem();
					psicoDao.salvar(psico);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Salvo com sucesso!"));
			recarregarLista();
			return "listPsicologo.jsf";
		} catch (Exception erroSalvar) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
					"Erro ao tentar salvar! Verifique dados do cadastro"));
			System.out.println("erro: " + erroSalvar.getMessage());
			return "Psicologo.jsf";
		}
	}
	
	public String editar(Psicologo psicoEditar) {
		try{
			psico = new Psicologo();
			psico = psicoEditar;
			idCargo = psico.getCargoPsico().getIdCargo();
			
			File file = new File("c:\\temp\\" + psico.getIdPsicologo() + "psic" + ".jpeg");
	        if(file.exists()){
	        	nomeFoto = file.toString();
	        }
			return "psicologo.jsf";
		}
		catch(Exception erro){
			return "listPsicologo.jsf";
		}
	}

	public void imagem() {
		try {
			// nomeFoto = arquivo.getFileName();
			// if(nomeFoto != null && nomeFoto.equals("")){
			String caminhoDaFoto = "c:\\temp\\" + psico.getIdPsicologo() + "psic" + ".jpeg";
			InputStream is = arquivo.getInputstream();
			FileOutputStream fs = new FileOutputStream(caminhoDaFoto);
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = is.read(bytes)) != -1) {
				fs.write(bytes, 0, read);
			}
			fs.close();
			psico.setCaminhoFoto(caminhoDaFoto);

		} catch (Exception errImage) {
			System.out.println("erro: " + errImage.getMessage());
		}

	}

	private void listar() {
		try {
			listPsico = new ArrayList<Psicologo>();
			listPsico = psicoDao.listarPsicologos("");
			cargoPsico = cDao.buscaPorNome("Psicólogo");
		} catch (Exception erroLista) {
		}
	}

	public void recarregarLista() {
		listPsico = new PsicologoDao().listarPsicologos("");
//		nomeCargo = "Psicólogo";
	}

	// getts e setts
	public Psicologo getPsico() {
		return psico;
	}

	public void setPsico(Psicologo psico) {
		this.psico = psico;
	}

	public PsicologoDao getPsicoDao() {
		return psicoDao;
	}

	public void setPsicoDao(PsicologoDao psicoDao) {
		this.psicoDao = psicoDao;
	}

	public CargoDao getcDao() {
		return cDao;
	}

	public void setcDao(CargoDao cDao) {
		this.cDao = cDao;
	}

	public List<Psicologo> getListPsico() {
		return listPsico;
	}

	public void setListPsico(List<Psicologo> listPsico) {
		this.listPsico = listPsico;
	}

	public UploadedFileWrapper getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFileWrapper arquivo) {
		this.arquivo = arquivo;
	}

	public Cargo getCargoPsico() {
		return cargoPsico;
	}

	public void setCargoPsico(Cargo cargoPsico) {
		this.cargoPsico = cargoPsico;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeFoto() {
		return nomeFoto;
	}

	public void setNomeFoto(String nomeFoto) {
		this.nomeFoto = nomeFoto;
	}
	
}
