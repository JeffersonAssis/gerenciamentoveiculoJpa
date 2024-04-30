package br.com.concessionaria.dao.interfac;

import java.util.List;

import br.com.concessionaria.model.Veiculo;

public interface IVeiculoDAO {
	void save(Veiculo v);
	void delete(String placa);
	void update(String placa, Veiculo v);
	Veiculo findPlaca(String placa);
	List<Veiculo> findModelo(String modelo);
	List<Veiculo> findAllLoja(String nome);
	void venderVeiculo(String placa,Veiculo v);
}
