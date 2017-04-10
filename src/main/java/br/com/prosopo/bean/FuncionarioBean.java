package br.com.prosopo.bean;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	private String cep;
	private List<Funcionario> listFunc;
	private List<Cargo> listCargo;

	private Long idCargo;
	private Long idUser;

	private UploadedFileWrapper arquivo;

	@PostConstruct
	public void init() {
		listar();
		listFunc = new ArrayList<Funcionario>();
		listFunc = funcDao.listarFuncionarios("");
		listCargo= new ArrayList<Cargo>();
		listCargo = cDao.listarCargo("");

	}

	
//	 * "C:\\development\\imagens\\funcionarios");
//	 * this.func.setCaminhoFoto(this.arquivo.getTitulo()); }
//	 */

	public String salvar() {
		try {
			// if(func.getIdFuncionario() == 0){
			// func.setIdFuncionario(null);
			// }
			Cargo cargo = new CargoDao().buscaPorId(idCargo);
			System.out.println("Cargo encontrado " + cargo);
			func.setCargoFuncionario(cargo);			
			funcDao.salvar(func);

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
			funcDao.salvar(func);
			recarregarLista();
			return "listFuncionario.jsf";
		} catch (Exception ef) {
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
			return "funcionario.jsf";
		}
		catch(Exception erro){
			return "listFuncionario.jsf";
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
		listFunc = new FuncionarioDao().listarFuncionarios("");
		listCargo = new CargoDao().listarCargo("");
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
