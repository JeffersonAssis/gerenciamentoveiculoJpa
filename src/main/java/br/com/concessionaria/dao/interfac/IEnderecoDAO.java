package br.com.concessionaria.dao.interfac;

import br.com.concessionaria.model.Endereco;

public interface IEnderecoDAO {

	void save(Endereco e);
	void deleteCep(String cep);
	Endereco findByCep(String cep);
}
