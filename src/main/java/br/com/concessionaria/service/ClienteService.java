package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.dao.impl.ClienteDAO;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Endereco;

public class ClienteService {

	static final ClienteDAO cDao = new ClienteDAO();

	public static void save(Cliente c) {
		if (!c.getCpf().isEmpty() && !c.getNome().isEmpty() && (c.getCpf().length() == 11)) {
			Endereco end = EnderecoService.buscarCep(c.getEndereco().getCep());
			c.setEndereco(end);
			if (!c.getEndereco().getCep().isEmpty())
				cDao.save(c);
		} else {
			throw new NullPointerException("Informações incompletas!");
		}
	}

	public static Cliente buscarCpf(String cpf) {
		if (cpf.length() == 11) {
			return cDao.findCpf(cpf);
		} else {
			throw new NullPointerException("Cliente não Cadastrado");
		}
	}

	public static Cliente update(String cpf, Cliente c) {
		if (cpf.length() == 11 && !c.getNome().isEmpty()) {
			cDao.update(cpf, c);
		} else {
			throw new NullPointerException("CPF inválido!");
		}
		return buscarCpf(cpf);
	}

	public static void deleteCpf(String cpf) {
		if (cpf.length() == 11) {
			cDao.deleteCpf(cpf);
		} else {
			throw new NullPointerException("CPF informado inválido!");
		}
	}
	
	public static List<Cliente> buscarListaCliente(String nome) {
		if (!nome.isEmpty()) {
			return cDao.findClienteNome(nome);
		} else {
			throw new NullPointerException("Cliente não Cadastrado");
		}
	}
}
