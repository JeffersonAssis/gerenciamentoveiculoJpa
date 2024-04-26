package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.dao.impl.FuncionarioDAO;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Funcionario;

public class FuncionarioSevice {
	
	static final FuncionarioDAO fDao = new FuncionarioDAO();

	public static void save(Funcionario c) {
		if (!c.getCpf().isEmpty() && !c.getMatricula().isEmpty() && !c.getNome().isEmpty() && (c.getCpf().length() == 11)) {
			Endereco end = EnderecoService.buscarCep(c.getEndereco().getCep());
			c.setEndereco(end);
			if (!c.getEndereco().getCep().isEmpty())
				fDao.save(c);
		} else {
			throw new NullPointerException("Informações incompletas!");
		}
	}

	public static Funcionario buscarMatricula(String matricula) {
		if (matricula != null) {
			return fDao.findByMatricula(matricula);
		} else {
			throw new NullPointerException("Funcionario não Cadastrado");
		}
	}

	public static Funcionario update(String matricula, Funcionario fun) {
		if (matricula != null  && !fun.getNome().isEmpty()) {
			fDao.update(matricula, fun);
		} else {
			throw new NullPointerException("Matricula inválido!");
		}
		return buscarMatricula(matricula);
	}

	public static void deleteMatricula(String matricula) {
		if (matricula != null) {
			fDao.deleteMatricula(matricula);
		} else {
			throw new NullPointerException("Matricula informado inválido!");
		}
	}
	
	public static List<Funcionario> buscarTodos() {
		
		return fDao.findAll();
	}
}
