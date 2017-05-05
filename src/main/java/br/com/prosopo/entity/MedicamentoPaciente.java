package br.com.prosopo.entity;

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

@Entity
@Table(name="MedicamentoPaciente")
public class MedicamentoPaciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idMedPaciente;
	@ManyToOne
	@JoinColumn(name="MedicamentoPaciente")
	private Medicamento medicamentoPaciente;
	@Column(name="Dosagem")
	private String dosagem;
	@Column(name="MedicoResponsavel")
	private String medicoResponsavel;
	@Column(name="Observacao")
	private String observacao;
	@Temporal(value=TemporalType.DATE)
	@Column(name="DataInicio")
	private Date dataInicio;
	@Temporal(value=TemporalType.DATE)
	@Column(name="DataFim")
	private Date dataFim;
	//um paciente pode ter muitos medicamentos
	@ManyToOne
	@JoinColumn(name="FkPaciente")
	private Paciente fkPaciente;

	//getts e setts
	public Long getIdMedPaciente() {
		return idMedPaciente;
	}
	public void setIdMedPaciente(Long idMedPaciente) {
		this.idMedPaciente = idMedPaciente;
	}
	public Medicamento getMedicamentoPaciente() {
		return medicamentoPaciente;
	}
	public void setMedicamentoPaciente(Medicamento medicamentoPaciente) {
		this.medicamentoPaciente = medicamentoPaciente;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	public String getMedicoResponsavel() {
		return medicoResponsavel;
	}
	public void setMedicoResponsavel(String medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Paciente getFkPaciente() {
		return fkPaciente;
	}
	public void setFkPaciente(Paciente fkPaciente) {
		this.fkPaciente = fkPaciente;
	}
	
	
	public MedicamentoPaciente() {
		super();
	}
	public MedicamentoPaciente(Long idMedPaciente, Medicamento medicamentoPaciente, String dosagem,
			String medicoResponsavel, String observacao, Date dataInicio, Date dataFim, Paciente fkPaciente) {
		super();
		this.idMedPaciente = idMedPaciente;
		this.medicamentoPaciente = medicamentoPaciente;
		this.dosagem = dosagem;
		this.medicoResponsavel = medicoResponsavel;
		this.observacao = observacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.fkPaciente = fkPaciente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dosagem == null) ? 0 : dosagem.hashCode());
		result = prime * result + ((fkPaciente == null) ? 0 : fkPaciente.hashCode());
		result = prime * result + ((idMedPaciente == null) ? 0 : idMedPaciente.hashCode());
		result = prime * result + ((medicamentoPaciente == null) ? 0 : medicamentoPaciente.hashCode());
		result = prime * result + ((medicoResponsavel == null) ? 0 : medicoResponsavel.hashCode());
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
		MedicamentoPaciente other = (MedicamentoPaciente) obj;
		if (dosagem == null) {
			if (other.dosagem != null)
				return false;
		} else if (!dosagem.equals(other.dosagem))
			return false;
		if (fkPaciente == null) {
			if (other.fkPaciente != null)
				return false;
		} else if (!fkPaciente.equals(other.fkPaciente))
			return false;
		if (idMedPaciente == null) {
			if (other.idMedPaciente != null)
				return false;
		} else if (!idMedPaciente.equals(other.idMedPaciente))
			return false;
		if (medicamentoPaciente == null) {
			if (other.medicamentoPaciente != null)
				return false;
		} else if (!medicamentoPaciente.equals(other.medicamentoPaciente))
			return false;
		if (medicoResponsavel == null) {
			if (other.medicoResponsavel != null)
				return false;
		} else if (!medicoResponsavel.equals(other.medicoResponsavel))
			return false;
		return true;
	}
	
}
