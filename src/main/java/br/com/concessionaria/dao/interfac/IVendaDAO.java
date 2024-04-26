package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Venda;

public interface IVendaDAO {
	
	void save(Venda venda);
	Venda findByString (String param);
	void deleteString(String param);
	List<Venda> findAll();
}
