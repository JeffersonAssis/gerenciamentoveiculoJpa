package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Cliente;

public interface IClienteDAO {
	
	void save(Cliente c);
	void deleteCpf(String cpf);
	void update(String cpf, Cliente c);
	Cliente findCpf(String cpf);
	List<Cliente> findClienteNome(String nome);
}
