package br.com.prosopo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Convenio")
public class Convenio extends Endereco{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idConvenio;
	@Column(name="RazaoSocial")
	private String razaoSocial;
	@Column(name="NomeFantasia")
	private String nomeFantasia;
	@Column(name="CNPJ")
	private String cnpj;
	@Column(name="InscricaoEstadual")
	private String inscEstadual;
	@Column(name="Telefone1")
	private String telefone1;
	@Column(name="Telefone2")
	private String telefone2;
	@Column(name="HomePage")
	private String homePage;
	@Column(name="Email")
	private String eMail;
	@Column(name="Valor_Repasse", precision = 10, scale = 2)
	private BigDecimal valorRepasse;
	@Column(name="Data_VctoRecb")
	@Range(min = 1, max = 30, message = "Tem que ser entre 1 à 30 dia de cada mês")
	private int diaVencimento;
	@OneToMany(mappedBy = "convenio")
	//@JoinColumn(name= "Pacientes")
	private List<Paciente> pacientesConvenio;
	@Column(name="Status")
	private boolean status;
	//getts e setts
	public Long getIdConvenio() {
		return idConvenio;
	}
	public void setIdConvenio(Long idConvenio) {
		this.idConvenio = idConvenio;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public BigDecimal getValorRepasse() {
		return valorRepasse;
	}
	public void setValorRepasse(BigDecimal valorRepasse) {
		this.valorRepasse = valorRepasse;
	}
	public int getDataRecebimento() {
		return diaVencimento;
	}
	public void setDataRecebimento(int dataRecebimento) {
		this.diaVencimento = dataRecebimento;
	}
	public List<Paciente> getPacientesConvenio() {
		return pacientesConvenio;
	}
	public void setPacientesConvenio(List<Paciente> pacientesConvenio) {
		this.pacientesConvenio = pacientesConvenio;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	//construtores
	public Convenio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Convenio(Long idConvenio, String razaoSocial, String nomeFantasia, String cnpj, String inscEstadual,
			String telefone1, String telefone2, String homePage, String eMail, BigDecimal valorRepasse,
			int dataRecebimento, List<Paciente> pacientesConvenio, boolean status) {
		super();
		this.idConvenio = idConvenio;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.homePage = homePage;
		this.eMail = eMail;
		this.valorRepasse = valorRepasse;
		this.diaVencimento = dataRecebimento;
		this.pacientesConvenio = pacientesConvenio;
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((homePage == null) ? 0 : homePage.hashCode());
		result = prime * result + ((idConvenio == null) ? 0 : idConvenio.hashCode());
		result = prime * result + ((inscEstadual == null) ? 0 : inscEstadual.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((pacientesConvenio == null) ? 0 : pacientesConvenio.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((telefone1 == null) ? 0 : telefone1.hashCode());
		result = prime * result + ((telefone2 == null) ? 0 : telefone2.hashCode());
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
		Convenio other = (Convenio) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (homePage == null) {
			if (other.homePage != null)
				return false;
		} else if (!homePage.equals(other.homePage))
			return false;
		if (idConvenio == null) {
			if (other.idConvenio != null)
				return false;
		} else if (!idConvenio.equals(other.idConvenio))
			return false;
		if (inscEstadual == null) {
			if (other.inscEstadual != null)
				return false;
		} else if (!inscEstadual.equals(other.inscEstadual))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (pacientesConvenio == null) {
			if (other.pacientesConvenio != null)
				return false;
		} else if (!pacientesConvenio.equals(other.pacientesConvenio))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (status != other.status)
			return false;
		if (telefone1 == null) {
			if (other.telefone1 != null)
				return false;
		} else if (!telefone1.equals(other.telefone1))
			return false;
		if (telefone2 == null) {
			if (other.telefone2 != null)
				return false;
		} else if (!telefone2.equals(other.telefone2))
			return false;
		return true;
	}
	
	
}
