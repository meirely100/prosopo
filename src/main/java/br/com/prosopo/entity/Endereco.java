package br.com.prosopo.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@MappedSuperclass
public abstract class Endereco {
	@SerializedName("cep")
	@Expose
	@Column(name="CEP", nullable=true)
	private String cep;
	@SerializedName("logradouro")
	@Expose
	@Column(name="Logradouro", nullable=false)
	private String logradouro;
	@Column(name="Numero", nullable=false)
	
	private String numero;
	@SerializedName("complemento")
	@Expose
	@Column(name="Complemento", nullable=false)
	private String complemento;
	@SerializedName("bairro")
	@Expose
	@Column(name="Bairro", nullable=false)
	private String bairro;
	@SerializedName("cidade")
	@Expose
	@Column(name="Cidade", nullable=false)
	private String cidade;
	@SerializedName("uf")
	@Expose
	@Column(name="Estado", nullable=false)
	private String uf;
	
	//getts and setts
public Endereco(){
		
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}	
	//Construtores
	public Endereco(String cep, String rua, String numero, String complemento, String bairro, String cidade,
			String estado, String pais) {
		super();
		this.cep = cep;
		this.logradouro = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = estado;
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + uf + "]";
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cep).append(logradouro).append(complemento).append(bairro)
				.append(cidade).append(uf).toHashCode();
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Endereco) == false) {
			return false;
		}
		Endereco rhs = ((Endereco) other);
		return new EqualsBuilder().append(cep, rhs.cep).append(logradouro, rhs.logradouro)
				.append(complemento, rhs.complemento).append(bairro, rhs.bairro).append(cidade, rhs.cidade)
				.append(uf, rhs.uf).isEquals();
	}
	
}
