package br.com.prosopo.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Endereco {
	
	@Column(name="CEP", nullable=false)
	private String cep;
	@Column(name="Endereco", nullable=false)
	private String rua;
	@Column(name="Numero", nullable=false)
	private String numero;
	@Column(name="Complemento", nullable=false)
	private String complemento;
	@Column(name="Bairro", nullable=false)
	private String bairro;
	@Column(name="Cidade", nullable=false)
	private String cidade;
	@Column(name="Estado", nullable=false)
	private String estado;
	@Column(name="Pais", nullable=false)
	private String pais;
	
	//getts and setts
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	//Construtores
	public Endereco(){
		
	}
	public Endereco(String cep, String rua, String numero, String complemento, String bairro, String cidade,
			String estado, String pais) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "]";
	}
	
	
}
