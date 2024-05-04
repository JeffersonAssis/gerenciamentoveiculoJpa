package br.com.concessionaria.dao.impl;

import java.util.List;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.ILojaDAO;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.service.EnderecoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LojaDAO implements ILojaDAO {

	static final EntityManager em = Conexao.getConn();

	@Override
	public void save(Loja l) {
		EntityTransaction transction = em.getTransaction();
		try {
			transction.begin();
			em.persist(l);
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void deleteNome(String nome) {
		EntityTransaction transction = em.getTransaction();
		Loja l = findByNome(nome);
		try {
			transction.begin();
			if (!l.getNome().isEmpty()) {
				em.remove(l);
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
	public void update(String nome, Loja l) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			Loja lo = findByNome(nome);

			if (lo != null) {
				Endereco end = EnderecoService.buscarCep(l.getEndereco().getCep());
				lo.setNome(l.getNome());
				lo.setEndereco(end);
				lo.setNumEndereco(l.getNumEndereco());
				em.merge(lo);
				transaction.commit();
			} else {
				System.out.println("Loja: " + nome + " não encontrado.");
			}
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public Loja findByNome(String nome) {
		try {
			return em.createNamedQuery("findByNomeLoja", Loja.class).setParameter("nome", "%"+nome+"%").getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Loja> findByAll() {
		try {
			return em.createNamedQuery("findByAllLoja", Loja.class).getResultList();
		} catch (Exception e) {

			return null;
		}
	}

}
