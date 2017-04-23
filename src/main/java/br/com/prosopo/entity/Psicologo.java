package br.com.prosopo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Psicologo")
public class Psicologo extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idPsicologo;
	@Column(name="Matricula")
	private Long matricula;
	@Column(name="Carteria_Trabalho", length= 20)
	private String numCartTrab;
	@Column(name="Serie_CartTrabalho", length= 20)
	private String serieCartTrab;
	@Temporal(value=TemporalType.DATE)
	@Column(name="DataAdmissao", nullable=false)
	private Date Admissao;
	@Temporal(value=TemporalType.DATE)
	@Column(name="Demissao")
	private Date dataDemissao;
	@ OneToOne
	@JoinColumn (name = "Fk_Cargo", nullable=false)
	private Cargo cargoPsico;
	@Column (name="CRP", unique=true, length=15, nullable=false)
	private String numCRP;
	//getts and setts
	public Long getIdPsicologo() {
		return idPsicologo;
	}


	public void setIdPsicologo(Long idPsicologo) {
		this.idPsicologo = idPsicologo;
	}


	public Long getMatricula() {
		return matricula;
	}


	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public String getNumCartTrab() {
		return numCartTrab;
	}


	public void setNumCartTrab(String numCartTrab) {
		this.numCartTrab = numCartTrab;
	}


	public String getSerieCartTrab() {
		return serieCartTrab;
	}


	public void setSerieCartTrab(String serieCartTrab) {
		this.serieCartTrab = serieCartTrab;
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


	public Cargo getCargoPsico() {
		return cargoPsico;
	}


	public void setCargoPsico(Cargo cargoPsico) {
		this.cargoPsico = cargoPsico;
	}


	public String getNumCRP() {
		return numCRP;
	}


	public void setNumCRP(String numCRP) {
		this.numCRP = numCRP;
	}
	
	//Construtores
		public Psicologo() {
			super();
			// TODO Auto-generated constructor stub
		}


	public Psicologo(Long idPsicologo, Long matricula, String numCartTrab, String serieCartTrab, Date admissao,
			Date dataDemissao, Cargo cargoPsico, String numCRP) {
		super();
		this.idPsicologo = idPsicologo;
		this.matricula = matricula;
		this.numCartTrab = numCartTrab;
		this.serieCartTrab = serieCartTrab;
		Admissao = admissao;
		this.dataDemissao = dataDemissao;
		this.cargoPsico = cargoPsico;
		this.numCRP = numCRP;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cargoPsico == null) ? 0 : cargoPsico.hashCode());
		result = prime * result + ((idPsicologo == null) ? 0 : idPsicologo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((numCRP == null) ? 0 : numCRP.hashCode());
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
		Psicologo other = (Psicologo) obj;
		if (cargoPsico == null) {
			if (other.cargoPsico != null)
				return false;
		} else if (!cargoPsico.equals(other.cargoPsico))
			return false;
		if (idPsicologo == null) {
			if (other.idPsicologo != null)
				return false;
		} else if (!idPsicologo.equals(other.idPsicologo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (numCRP == null) {
			if (other.numCRP != null)
				return false;
		} else if (!numCRP.equals(other.numCRP))
			return false;
		return true;
	}

}
