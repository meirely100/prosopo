package br.com.prosopo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Funcionario")
public class Funcionario extends Pessoa{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idFuncionario;
	@Column(name="Matricula")
	private Long matricula;
	@Temporal(value=TemporalType.DATE)
	@Column(name="DataAdmissao", nullable=false)
	private Date Admissao;
	@Temporal(value=TemporalType.DATE)
	@Column(name="Demissao")
	private Date dataDemissao;
	@JoinColumn (name = "Fk_Cargo", referencedColumnName = "ID", nullable=false)
	@ ManyToOne
	private Cargo cargoFuncionario;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name="USER_ID", nullable=true)
//    @PrimaryKeyJoinColumn
	private Usuario user;
	//getts and setts
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
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	//construtores
	
	public Funcionario(Long idFuncionario, Long matricula, Date admissao, Date dataDemissao, Cargo cargoFuncionario,
			Usuario user) {
		super();
		this.idFuncionario = idFuncionario;
		this.matricula = matricula;
		Admissao = admissao;
		this.dataDemissao = dataDemissao;
		this.cargoFuncionario = cargoFuncionario;
		this.user = user;
	}
	public Funcionario() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Admissao == null) ? 0 : Admissao.hashCode());
		result = prime * result + ((cargoFuncionario == null) ? 0 : cargoFuncionario.hashCode());
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (Admissao == null) {
			if (other.Admissao != null)
				return false;
		} else if (!Admissao.equals(other.Admissao))
			return false;
		if (cargoFuncionario == null) {
			if (other.cargoFuncionario != null)
				return false;
		} else if (!cargoFuncionario.equals(other.cargoFuncionario))
			return false;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
