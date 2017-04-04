package br.com.prosopo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cargo")
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long idCargo;

	@Column(length = 30, nullable = false, unique= true)
	private String cargo;

	//getts and setts
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long id) {
		this.idCargo = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	//Construtores

	public Cargo(){
		super();
	}

	public Cargo(Long id, String cargo) {
		super();
		this.idCargo = id;
		this.cargo = cargo;
	}
	// hashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((idCargo == null) ? 0 : idCargo.hashCode());
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
		Cargo other = (Cargo) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (idCargo == null) {
			if (other.idCargo != null)
				return false;
		} else if (!idCargo.equals(other.idCargo))
			return false;
		return true;
	}

}