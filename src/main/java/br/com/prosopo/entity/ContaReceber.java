package br.com.prosopo.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the contareceber database table.
 * 
 */
@Entity
@Table(name="ContaReceber")
public class ContaReceber  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idcontaReceber;

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	

	@Column(length=100)
	private String descricao;
	
	@Column(length=100)
	private String cliente;

	

	@Column(length=45)
	private String formaPagamento;

	@Column(length=50)
	private String titulo;
	
	

	@Column(length=50)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private double valor;


	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Long getIdcontaReceber() {
		return idcontaReceber;
	}

	public void setIdcontaReceber(Long idcontaReceber) {
		this.idcontaReceber = idcontaReceber;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}