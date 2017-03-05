package br.com.prosopo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prosopo.dao.CargoDao;
import br.com.prosopo.entity.Cargo;

@ManagedBean(name="mBeanCargo")
@ViewScoped
public class CargoBean {

	private Cargo cargo = new Cargo();
	private String nome;
	private List<Cargo> cargos;

	CargoDao cDao = new CargoDao();




	@PostConstruct
	public void init() {
		cargos = cDao.ListarCargo();
		if(cargos == null){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nennhum registro cadastrado!",""));
		}
	}

	public void Salvar(Cargo c){

		cDao.Salvar(c);
		if(cargo.getIdCargo() != 0){
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargo alterado com sucesso!", ""));
		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo cargo salvo com sucesso!", ""));
		}
		Listar();

	}

	public Cargo editar(Cargo c){
		return cargo = c;
	}
	
	public void excluir(Cargo c){
		cDao.excluir(c);
		Listar();
		// listar cargos
	}
	
	
	public ArrayList<Cargo> Listar(){

		cargos = new ArrayList<Cargo>();
		return (ArrayList<Cargo>) cDao.ListarCargo();
	}
	
	public void teste(){
		System.out.println("DEU BUA!!!");
	}
	
	
	
	
	
	
	
	//getts and setts
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}