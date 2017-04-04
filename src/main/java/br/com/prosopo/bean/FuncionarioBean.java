package br.com.prosopo.bean;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.prosopo.dao.CargoDao;
import br.com.prosopo.dao.FuncionarioDao;
import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;

@ManagedBean(name = "mBeanFuncionario")
@SessionScoped
public class FuncionarioBean {
	private Funcionario func = new Funcionario();
	private FuncionarioDao FuncDao = new FuncionarioDao();
	private CargoDao cDao = new CargoDao();
	private String cep;
	private List<Funcionario> listFunc;
	private List<Cargo> listCargo;

	private Long idCargo;
	private Long idUser;

//	 private ApplicationPart foto;
	private String valorImagem;
	private String descricao;
	private String caminhoDaFoto;
	private File file;
	
	
	@PostConstruct
	public void init() {
		listar();
		listFunc = new ArrayList<Funcionario>();
	}

	public void salvar() {
		try{
//			if(func.getIdFuncionario() == 0){
//				func.setIdFuncionario(null);
//			}
			Cargo cargo = new CargoDao().buscaPorId(idCargo);
			System.out.println("Cargo encontrado "+ cargo);
			func.setCargoFuncionario(cargo);
			FuncDao.salvar(func);
			System.out.println("Deu boa " + func.toString());
		}
		catch(Exception ef){
			System.out.println("erro: "+ ef.getMessage());
			
		}
		

	}

	public String editar(Funcionario f) {
		func = new Funcionario();
		listCargo = new ArrayList<Cargo>();
		func = f;
		idCargo = func.getCargoFuncionario().getIdCargo();
		return "funcionario.jsf";
	}

	// tratamento data
	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}
	
	private void listar() {
		listCargo = new ArrayList<Cargo>();
		listCargo = cDao.listarCargo("");
	}

	// getts and setts
	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public FuncionarioDao getFuncDao() {
		return FuncDao;
	}

	public void setFuncDao(FuncionarioDao funcDao) {
		FuncDao = funcDao;
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

	public String getValorImagem() {
		return valorImagem;
	}

	public void setValorImagem(String valorImagem) {
		this.valorImagem = valorImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminhoDaFoto() {
		return caminhoDaFoto;
	}

	public void setCaminhoDaFoto(String caminhoDaFoto) {
		this.caminhoDaFoto = caminhoDaFoto;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
