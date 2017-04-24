package br.com.prosopo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Estabelecimento")
public class Estabelecimento implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(unique=true, nullable=false)
private Long idEstabelecimento;

@Column(name="CPF_CNPJ", length=20)
private String cpfCnpj;

public String getRazaoSocial() {
	return razaoSocial;
}

public void setRazaoSocial(String razaoSocial) {
	this.razaoSocial = razaoSocial;
}

private int idAdministrador;

@Lob
private byte[] logomarca;

@Transient
private String caminho;



@Column(length=100)
private String nomeFantasia;

@Column(length=50)
private String pessoaTipo;

@Column(length=50)
private String razaoSocial;

public Estabelecimento() {
}



public Long getIdEstabelecimento() {
	return idEstabelecimento;
}

public void setIdEstabelecimento(Long idEstabelecimento) {
	this.idEstabelecimento = idEstabelecimento;
}

public String getCpfCnpj() {
	return this.cpfCnpj;
}

public void setCpfCnpj(String cpfCnpj) {
	this.cpfCnpj = cpfCnpj;
}

public int getIdAdministrador() {
	return this.idAdministrador;
}

public void setIdAdministrador(int idAdministrador) {
	this.idAdministrador = idAdministrador;
}

public byte[] getLogomarca() {
	return this.logomarca;
}

public void setLogomarca(byte[] logomarca) {
	this.logomarca = logomarca;
}

public String getNomeFantasia() {
	return this.nomeFantasia;
}

public void setNomeFantasia(String nomeFantasia) {
	this.nomeFantasia = nomeFantasia;
}

public String getPessoaTipo() {
	return this.pessoaTipo;
}

public void setPessoaTipo(String pessoaTipo) {
	this.pessoaTipo = pessoaTipo;
}


public String getCaminho() {
	return caminho;
}

public void setCaminho(String caminho) {
	this.caminho = caminho;
}
	
}
