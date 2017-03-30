package br.com.prosopo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prosopo.entity.Cargo;
import br.com.prosopo.entity.Funcionario;

@ManagedBean(name="mBeanFuncionario")
@SessionScoped
public class FuncionarioBean {
	private Funcionario func = new Funcionario();
	private String nomeFunc;
	private List<Funcionario> listFunc;
	private List<Cargo> listCargo;
	
	private Long idCargo;
	
	
	
	
	
	
	
	
	
	

}
