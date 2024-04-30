package br.com.concessionaria.dao.impl;

import java.util.List;

import br.com.concessionaria.conexao.Conexao;
import br.com.concessionaria.dao.interfac.IFuncionarioDAO;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.service.EnderecoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FuncionarioDAO implements IFuncionarioDAO{
	
	static final EntityManager em = Conexao.getConn();
	
	@Override
	public void save(Funcionario c) {
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
	public void deleteMatricula(String matricula) {
		EntityTransaction transction = em.getTransaction();
		Funcionario c = findByMatricula(matricula);
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
	public void update(String matricula, Funcionario c) {
		EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            
          Funcionario fun = findByMatricula(matricula);
            
            if (fun != null) {
            	Endereco end = EnderecoService.buscarCep(c.getEndereco().getCep());
                fun.setNome(c.getNome());
                fun.setEndereco(end);
                fun.setNumResidencia(c.getNumResidencia());
                fun.setCpf(c.getCpf());
                em.merge(fun);
                transaction.commit();
            } else {
                System.out.println("Funcionario com matricula " + matricula + " não encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		
	}
	
	@Override
	public Funcionario findByMatricula(String matricula) {
		try {
			return em.createNamedQuery("findByMatricula", Funcionario.class).setParameter("matricula", matricula).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Funcionario> findAll() {
		try {
			return em.createNamedQuery("findByAll", Funcionario.class).getResultList();
			} catch (Exception e) {

				return null;
			}
	}
	
	@Override
	public List<Funcionario> findAlldaLoja(String nome) {
		try {
			return em.createNamedQuery("findByNomeLojaAll", Funcionario.class).setParameter("nome", "%"+nome+"%").getResultList();
			} catch (Exception e) {

				return null;
			}
	}
}
