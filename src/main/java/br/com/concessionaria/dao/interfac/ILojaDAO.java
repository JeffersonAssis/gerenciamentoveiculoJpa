package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Loja;

public interface ILojaDAO {
	
	void save(Loja l);
	void deleteNome(String nome);
	void update(String nome, Loja l);
	Loja findByNome(String nome);
	List<Loja> findByAll();
}
