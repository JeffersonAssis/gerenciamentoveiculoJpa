package br.com.concessionaria.dao.impl;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.IClienteDAO;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.service.EnderecoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClienteDAO implements IClienteDAO{
	
	static final EntityManager em = Conexao.getConn();
	
	@Override
	public void save(Cliente c) {
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
	public void deleteCpf(String cpf) {
		EntityTransaction transction = em.getTransaction();
		Cliente c = findCpf(cpf);
		try {
			transction.begin();
			if (!c.getCpf().isEmpty()) {
				em.remove(c);
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
	public void update(String cpf, Cliente c) {
		EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            
          Cliente cli = findCpf(cpf);
            
            if (cli != null) {
            	Endereco end = EnderecoService.buscarCep(c.getEndereco().getCep());
                cli.setNome(c.getNome());
                cli.setEndereco(end);
                cli.setNumResidencia(c.getNumResidencia());
                cli.setTelefone(c.getTelefone());
                em.merge(cli);
                transaction.commit();
            } else {
                System.out.println("Cliente com CPF " + cpf + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		
	}

	@Override
	public Cliente findCpf(String cpf) {
		try {
		return em.createNamedQuery("findByCpf", Cliente.class).setParameter("cpf", cpf).getSingleResult();
		} catch (Exception e) {

			return null;
		}

	}

}
