package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Funcionario;

public interface IFuncionarioDAO {
	
	void save(Funcionario f);
	void deleteMatricula(String matricula);
	void update(String matricula, Funcionario f);
	Funcionario findByMatricula(String matricula);
	List<Funcionario> findAll();
}
