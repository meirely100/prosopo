package br.com.prosopo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROSOPO");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
