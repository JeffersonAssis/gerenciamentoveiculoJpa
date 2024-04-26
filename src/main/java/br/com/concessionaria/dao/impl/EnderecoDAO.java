package br.com.concessionaria.dao.impl;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.IEnderecoDAO;
import br.com.concessionaria.model.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EnderecoDAO implements IEnderecoDAO {

	static final EntityManager em = Conexao.getConn();

	@Override
	public void save(Endereco c) {
		EntityTransaction transction = em.getTransaction();
		try {
			transction.begin();
			em.persist(c);
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCep(String cep) {
		EntityTransaction transction = em.getTransaction();
		Endereco end = findByCep(cep);
		try {
			transction.begin();
			if (!end.getCep().isEmpty()) {
				em.remove(end);
			}
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.getStackTrace();
		}

	}

	@Override
	public Endereco findByCep(String cep) {
		try {
			return em.createNamedQuery("findByCep", Endereco.class)
					.setParameter("cep", cep)
					.getSingleResult();
		} catch (Exception e) {

			return null;
		}

	}

}
