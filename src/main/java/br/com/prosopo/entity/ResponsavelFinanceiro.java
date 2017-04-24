package br.com.prosopo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Responsavel_Financeiro")
public class ResponsavelFinanceiro extends Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idResponsavel;
	@Column(name="Nome")
	private String nome;
	@Column(name="RG")
	private String rg;
	@Column(name="CPF")
	private String cpf;
	@Column(name="Sexo")
	private String sexo;
	@Column(name="Celular")
	private String celular;
	@Column(name="Tel_Residencial")
	private String residencial;
	
	//getts e setts
	public Long getIdResponsavel() {
		return idResponsavel;
	}
	public void setIdResponsavel(Long idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	//construtores
	public ResponsavelFinanceiro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponsavelFinanceiro(Long idResponsavel, String nome, String rg, String cpf, String sexo, String celular,
			String residencial) {
		super();
		this.idResponsavel = idResponsavel;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.celular = celular;
		this.residencial = residencial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((idResponsavel == null) ? 0 : idResponsavel.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsavelFinanceiro other = (ResponsavelFinanceiro) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (idResponsavel == null) {
			if (other.idResponsavel != null)
				return false;
		} else if (!idResponsavel.equals(other.idResponsavel))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	

}
