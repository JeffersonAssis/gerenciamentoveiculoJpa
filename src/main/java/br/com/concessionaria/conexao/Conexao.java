package br.com.concessionaria.conexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {
	private static EntityManager em = null; 
	public Conexao() {	}
	
	public static synchronized EntityManager getConn(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONCESSIONARIA-PU");
		if (em == null) {
			em = emf.createEntityManager();
		}

		return em;
	}
}
