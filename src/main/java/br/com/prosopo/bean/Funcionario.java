package br.com.prosopo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.prosopo.entity.Cargo;

@Entity
@Table(name="Funcionario")
public class Funcionario extends Pessoa{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idFuncionario")
	private Long idFuncionario;
	@Column(name="Matricula")
	private Long matricula;
	@Temporal(value=TemporalType.DATE)
	@Column(name="DataAdmissao")
	private Date Admissao;
	@Temporal(value=TemporalType.DATE)
	@Column(name="Demissao")
	private Date dataDemissao;
	@JoinColumn (name = "Fk_Cargo",  referencedColumnName = "idCargo")
	@ ManyToOne
	private Cargo cargoFuncionario;
	//getts and sett
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public Date getAdmissao() {
		return Admissao;
	}
	public void setAdmissao(Date admissao) {
		Admissao = admissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	public Cargo getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(Cargo cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}
	//Construtores
	public Funcionario(){
		
	}
	public Funcionario(Long idFuncionario, Long matricula, Date admissao, Date dataDemissao, Cargo cargoFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
		this.matricula = matricula;
		Admissao = admissao;
		this.dataDemissao = dataDemissao;
		this.cargoFuncionario = cargoFuncionario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
