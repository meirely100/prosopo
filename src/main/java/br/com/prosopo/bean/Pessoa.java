package br.com.prosopo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends Endereco implements Serializable {
	
	
	@Column(name="Nome", nullable=false)
	private String nome;
	@Column(name="cpf")
	private String cpf;
	@Column(name="rg")
	private String rg;
	@Column(name="sexo", nullable=false)
	private String sexo;
	@Column(name="dataNascimento", nullable=false)
	private String dataNasc;
	@Column(name="EstadoCivil")
	private String estadoCivil;
	@Column(name="Email")
	private String eMail;
	@Column(name="HomePage")
	private String homePage;
	@Column(name="Celular")
	private String celular;
	@Column(name="TelefoneResidencial")
	private String residencial;
	@Column(name="TelefoneRecado")
	private String recado;
	@Column(name="Foto")
	private String caminhoFoto;
	@Column(name="Status")
	private String status;
	
	//getts and setts
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	public String getRecado() {
		return recado;
	}
	public void setRecado(String recado) {
		this.recado = recado;
	}
	public String getCaminhoFoto() {
		return caminhoFoto;
	}
	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//Construtores
	public Pessoa(){
	}
	
	public Pessoa(String nome, String cpf, String rg, String sexo, String dataNasc, String estadoCivil, String eMail,
			String homePage, String celular, String residencial, String recado, String caminhoFoto, String status) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.estadoCivil = estadoCivil;
		this.eMail = eMail;
		this.homePage = homePage;
		this.celular = celular;
		this.residencial = residencial;
		this.recado = recado;
		this.caminhoFoto = caminhoFoto;
		this.status = status;
	}
	
}
