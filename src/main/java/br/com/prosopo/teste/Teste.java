package br.com.prosopo.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.prosopo.dao.Conexao;
import br.com.prosopo.dao.ContaPagarDAO;
import br.com.prosopo.dao.EstabelecimentoDAO;
import br.com.prosopo.entity.ContaPagar;
import br.com.prosopo.entity.Estabelecimento;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//           Teste Salvar OK          utilizando o metodo salvar da classe DAO                
		/*
				ContaPagar cp = new ContaPagar();
				cp.setDataPagamento(new Date(2017-03-20));
				cp.setDataVencimento(new Date(2017-03-20));
				cp.setDescricao("TESTE MAIN");
				cp.setFormaPagamento("dinheiro");
				cp.setDescricao("teste");
				cp.setStatus("paga");
				cp.setTitulo("TESTE");
				cp.setValor(100.3);
				
				
				ContaPagarDAO cpdao = new ContaPagarDAO();
				
				cpdao.Salvar(cp);
		*/
		Estabelecimento est = new Estabelecimento();
		est.setNomeFantasia("teste");
		est.setPessoaTipo("fisico");
		est.setRazaoSocial("teste");
		est.setCpfCnpj("12345677");
		EstabelecimentoDAO estDAO = new EstabelecimentoDAO();
		
		estDAO.Salvar(est);
		
	}
	
	
	
	
}
