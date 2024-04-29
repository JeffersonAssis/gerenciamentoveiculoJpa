package br.com.concessionaria.dao.impl;

import java.util.List;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.IVeiculoDAO;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.service.LojaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VeiculoDAO implements IVeiculoDAO {

	static final EntityManager em = Conexao.getConn();

	@Override
	public void save(Veiculo v) {
		EntityTransaction transction = em.getTransaction();
		try {
			transction.begin();
			em.persist(v);
			transction.commit();
		} catch (Exception e) {
			if (transction.isActive()) {
				transction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String placa) {
		EntityTransaction transction = em.getTransaction();
		Veiculo v = findPlaca(placa);
		try {
			transction.begin();
			if (!v.getPlaca().isEmpty()) {
				em.remove(v);
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
	public void update(String placa, Veiculo v) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Veiculo vo = findPlaca(placa);
			if (vo != null) {
				Loja l = LojaService.buscarNome(v.getLoja().getNome());
				vo.setLoja(l);
				vo.setAno(v.getAno());
				vo.setMarca(v.getMarca());
				vo.setMarca(v.getMarca());
				vo.setPlaca(v.getPlaca());
				vo.setValor(v.getValor());
				vo.setTipoVeiculo(v.getTipoVeiculo());
				vo.setVendido(v.getVendido());
				em.merge(vo);
				transaction.commit();
			} else {
				System.out.println("Veiculo com a placa: " + placa + " não encontrado.");
			}
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public Veiculo findPlaca(String placa) {
		try {
			return em.createNamedQuery("findByPlaca", Veiculo.class).setParameter("placa", placa).getSingleResult();
		} catch (Exception e) {
			throw new NullPointerException("Erro ou buscar dados");
		}
	}

	@Override
	public List<Veiculo> findAllLoja(String nome) {
		try {
			return em.createNamedQuery("findByVeiculoNomeLoja", Veiculo.class).setParameter("nome","%"+nome+"%").getResultList();
		} catch (Exception e) {

			throw new NullPointerException("Erro ou buscar dados");
		}
	}
	
	@Override
	public void venderVeiculo(String placa, Veiculo v) {
		EntityTransaction transaction= em.getTransaction();
		try {
			transaction.begin();
			Veiculo vo = findPlaca(placa);
			if (vo != null) {
				vo.setVendido(v.getVendido());
				em.merge(vo);
				transaction.commit();
			} else {
				System.out.println("Veiculo com a placa: " + placa + " não encontrado.");
			}
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Veiculo> findModelo(String modelo) {
		try {
			return em.createNamedQuery("findByModelo", Veiculo.class).setParameter("modelo", modelo).getResultList();
		} catch (Exception e) {
			throw new NullPointerException("Erro ou buscar dados");
		}
	}
	
	
}
