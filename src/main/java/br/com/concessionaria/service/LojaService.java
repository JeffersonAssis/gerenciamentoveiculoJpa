package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.dao.impl.LojaDAO;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Loja;

public class LojaService {
	
	static final LojaDAO lDao = new LojaDAO();

	public static void save(Loja c) {
		if (!c.getNome().isEmpty() && !c.getNumEndereco().isEmpty() ) {
			Endereco end = EnderecoService.buscarCep(c.getEndereco().getCep());
			c.setEndereco(end);
			if (!c.getEndereco().getCep().isEmpty())
				lDao.save(c);
		} else {
			throw new NullPointerException("Informações incompletas!");
		}
	}

	public static Loja buscarNome(String nome) {
		if (nome != null) {
			return lDao.findByNome(nome);
		} else {
			throw new NullPointerException("Loja não Cadastrado");
		}
	}

	public static Loja update(String nome, Loja lo) {
		if (nome != null  && !lo.getNome().isEmpty()) {
			lDao.update(nome, lo);
		} else {
			throw new NullPointerException("Loja inválido!");
		}
		return buscarNome(nome);
	}

	public static void deleteNome(String nome) {
		if (nome != null) {
			lDao.deleteNome(nome);
		} else {
			throw new NullPointerException("Loja informada inválido!");
		}
	}
	
	public static List<Loja> buscarTodos() {
		
		return lDao.findByAll();
	}
}
