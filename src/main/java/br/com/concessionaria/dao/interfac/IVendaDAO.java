package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Venda;

public interface IVendaDAO {
	
	void save(Venda venda);
	Venda findByString (String param);
	void deleteString(Venda v);
	List<Venda> findAll(String param);
	List<Venda> findCpf(String param);
}
