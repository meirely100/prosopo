package br.com.prosopo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="Paciente")
public class Paciente extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idPaciente;
	@Column(name="Profissao")
	private String profissao;
	@Column(name="Logico_RespFinanceiro")
	private boolean respFin;
	@ManyToOne
	@JoinColumn(name= "ResponsavelFinancerio", nullable= true)
	private ResponsavelFinanceiro responsavelFin;
	@Column(name="Parentesco_RespFin")
	private String parentesco;
	@Column(name="Tipo_Consulta")  //se é particular ou convenio
	private String tipoConsulta;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "Convenio", nullable= true)
	private Convenio convenio;
	@Column(name= "NumeroCarteiraConvenio", nullable= true)
	private String numCarteiraConv;
	@Column(name="Valor_Sessao", precision = 10, scale = 2)
	private BigDecimal valorConsulta;
	@Temporal(value=TemporalType.DATE)
	@Column(name="Data_VencimentoPgto")
	private Date dataVencPgto;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "Psicologo")
	private Psicologo psicologo;
	@Column(name="Observacao")
	private String obs;
	

}
