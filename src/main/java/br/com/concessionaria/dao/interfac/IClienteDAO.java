package br.com.concessionaria.dao.interfac;

import br.com.concessionaria.model.Cliente;

public interface IClienteDAO {
	
	void save(Cliente c);
	void deleteCpf(String cpf);
	void update(String cpf, Cliente c);
	Cliente findCpf(String cpf);
	
}
