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
import br.com.prosopo.dao.FuncionarioDao;
import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;

@ManagedBean(name = "mBeanFuncionario")
@SessionScoped
public class FuncionarioBean {
	private Funcionario func = new Funcionario();
	private FuncionarioDao funcDao = new FuncionarioDao();
	private CargoDao cDao = new CargoDao();
	private List<Funcionario> listFunc;
	private List<Cargo> listCargo;

	private Long idCargo;
	private Long idUser;

	private UploadedFileWrapper arquivo;
	String nomeFoto;
	
	//para retirar o psicologo da lista de cargos 
	Cargo cargoPsic = new Cargo();

	@PostConstruct
	public void init() {
		listar();
		listFunc = new ArrayList<Funcionario>();
		listFunc = funcDao.listarFuncionarios("");
		
		listCargo= new ArrayList<Cargo>();
		listCargo = cDao.listarCargo("");
		cargoPsic = cDao.buscaPorNome("Psicólogo");
		if(listCargo.contains(cargoPsic)){
			listCargo.remove(cargoPsic);
		}

	}
	
	

	public String salvar() {
		try {
			Cargo cargo = new CargoDao().buscaPorId(idCargo);
			Date dataDem = func.getDataDemissao();
			func.setCargoFuncionario(cargo);	
			
			if(dataDem == null){
				func.setStatus("ativo");
			}
			else if(dataDem != null){
		
				func.setStatus("inativo");
			}
			funcDao.salvar(func);
			if(nomeFoto == null || nomeFoto == ""){
				nomeFoto = arquivo.getFileName();
			}
			String pegarCaminho = func.getCaminhoFoto();
			String testeArq = arquivo.getFileName();
			if(nomeFoto != null && pegarCaminho == null){
				//chamando metodo para salvar foto, caso o usuário não tenha foto ou seja novo usuário
				imagem();
				funcDao.salvar(func);
			}
			else if(!(nomeFoto == null) && !(nomeFoto == pegarCaminho)){
				if(testeArq.hashCode()== 0){
					
				}
				else{
					//apago a imagem do diretorio
					File file = new File(pegarCaminho);  
					   file.delete();
					   //chamo novamente o metodo para salvar a nova imagem inserida
					   imagem();
					   funcDao.salvar(func);
				}
				
			}
			recarregarLista();
			return "listFuncionario.jsf";
		} catch (Exception ef) {
			FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", "Erro ao tentar salvar! Verifique dados do cadastro"));
			System.out.println("erro: " + ef.getMessage());
			return "funcionario.jsf";

		}

	}

	public String editar(Funcionario funcEditar) {
		try{
			func = new Funcionario();
			//listCargo = new ArrayList<Cargo>();
			func = funcEditar;
			idCargo = func.getCargoFuncionario().getIdCargo();
			
			File file = new File("c:\\temp\\" + func.getIdFuncionario() + ".jpeg");
	        if(file.exists()){
	        	nomeFoto = file.toString();
	        }
			return "funcionario.jsf";
		}
		catch(Exception erro){
			return "listFuncionario.jsf";
		}
		
	}
	public void imagem(){
		try{
//			nomeFoto = arquivo.getFileName();
//			if(nomeFoto != null && nomeFoto.equals("")){
				String caminhoDaFoto = "c:\\temp\\" + func.getIdFuncionario() + ".jpeg";
				InputStream is = arquivo.getInputstream();
				FileOutputStream fs = new FileOutputStream(caminhoDaFoto);
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = is.read(bytes)) != -1) {
					fs.write(bytes, 0, read);
				}
				fs.close();
				func.setCaminhoFoto(caminhoDaFoto);
			
		}catch (Exception errImage){
			System.out.println("erro: " + errImage.getMessage());
		}
		
	}

	// tratamento data
	// public void onDateSelect(SelectEvent event) {
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	// facesContext.addMessage(null,
	// new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected",
	// format.format(event.getObject())));
	// }

	// public void click() {
	// RequestContext requestContext = RequestContext.getCurrentInstance();
	// requestContext.update("form:display");
	// requestContext.execute("PF('dlg').show()");
	// }

	private void listar() {
		try{
			listCargo = new ArrayList<Cargo>();
			listCargo = cDao.listarCargo("");
			cargoPsic = new Cargo();
			cargoPsic = cDao.buscaPorNome("Psicólogo");
			if(listCargo.contains(cargoPsic)){
				listCargo.remove(cargoPsic);
			}
			listFunc = new ArrayList<Funcionario>();
			listFunc = funcDao.listarFuncionarios("");
		}
		catch(Exception erroLista){
			
		}
		
	}
	
	public void limpar(){
		//limparDados();
		func = new Funcionario();
		idCargo = null;
		init();	
	}
	
	public void recarregarLista(){
		listCargo = new CargoDao().listarCargo("");
		cargoPsic = new Cargo();
		cargoPsic = cDao.buscaPorNome("Psicólogo");
		if(listCargo.contains(cargoPsic)){
			listCargo.remove(cargoPsic);
		}
		listFunc = new FuncionarioDao().listarFuncionarios("");
		}

	// getts and setts
	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public FuncionarioDao getFuncDao() {
		return funcDao;
	}

	public void setFuncDao(FuncionarioDao funciDao) {
		funcDao = funciDao;
	}

	public List<Funcionario> getListFunc() {
		return listFunc;
	}

	public void setListFunc(List<Funcionario> listFunc) {
		this.listFunc = listFunc;
	}

	public List<Cargo> getListCargo() {
		return listCargo;
	}

	public void setListCargo(List<Cargo> listCargo) {
		this.listCargo = listCargo;
	}

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public UploadedFileWrapper  getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFileWrapper  arquivo) {
		this.arquivo = arquivo;
	}

}
