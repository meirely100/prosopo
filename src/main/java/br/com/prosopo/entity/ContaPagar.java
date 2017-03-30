package br.com.prosopo.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the contapagar database table.
 * 
 */
@Entity
@Table(name="ContaPagar")
public class ContaPagar  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idContaPagar")
	private Long idcontaPagar;
	

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(length=100)
	private String descricao;
	
	@Column(length=100)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length=50)
	private String formaPagamento;

	@Column(length=50)
	private String titulo;

	private double valor;



	public Long getIdcontaPagar() {
		return idcontaPagar;
	}

	public void setIdcontaPagar(Long idcontaPagar) {
		this.idcontaPagar = idcontaPagar;
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

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}