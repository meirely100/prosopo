package br.com.prosopo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Medicamento")
public class Medicamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idMedicamento;
	
	@Column (name="NomeMedicamento")
	private String nomeMedicamento;
	@Column (name="Descricao")
	private String descricao;
	//getts e setts
	public Long getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
//construtores	
	public Medicamento() {
		super();
	}
	public Medicamento(Long idMedicamento, String nomeMedicamento, String descricao) {
		super();
		this.idMedicamento = idMedicamento;
		this.nomeMedicamento = nomeMedicamento;
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMedicamento == null) ? 0 : idMedicamento.hashCode());
		result = prime * result + ((nomeMedicamento == null) ? 0 : nomeMedicamento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (idMedicamento == null) {
			if (other.idMedicamento != null)
				return false;
		} else if (!idMedicamento.equals(other.idMedicamento))
			return false;
		if (nomeMedicamento == null) {
			if (other.nomeMedicamento != null)
				return false;
		} else if (!nomeMedicamento.equals(other.nomeMedicamento))
			return false;
		return true;
	}
	
}
