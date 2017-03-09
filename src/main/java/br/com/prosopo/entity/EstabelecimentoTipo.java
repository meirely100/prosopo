package br.com.prosopo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Tipo_Estabelecimento")
public class EstabelecimentoTipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idTipoEst;
	@Column(name="Descricao")
	private String descricao;
	
	//getts and setts
	public Long getIdTipoEst() {
		return idTipoEst;
	}
	public void setIdTipoEst(Long idTipoEst) {
		this.idTipoEst = idTipoEst;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	//construtores
	public EstabelecimentoTipo(){
		
	}
	
	public EstabelecimentoTipo(Long idTipoEst, String descricao) {
		super();
		this.idTipoEst = idTipoEst;
		this.descricao = descricao;
	}

}
