package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.dao.impl.VeiculoDAO;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;

public class VeiculoService {

	static final VeiculoDAO vDao = new VeiculoDAO();

	public static void save(Veiculo c) {
		if (!c.getPlaca().isEmpty() && !c.getMarca().isEmpty()) {
			Loja l = LojaService.buscarNome(c.getLoja().getNome());
			c.setLoja(l);
			if (!c.getLoja().getNome().isEmpty())
				vDao.save(c);
		} else {
			throw new NullPointerException("Informações incompletas!");
		}
	}

	public static Veiculo buscarPlaca(String placa) {
		if (placa != null) {
			return vDao.findPlaca(placa);
		} else {
			throw new NullPointerException("Veiculo não Cadastrado");
		}
	}

	public static Veiculo update(String placa, Veiculo vo) {
		if (placa != null && !vo.getPlaca().isEmpty()) {
			vDao.update(placa, vo);
		} else {
			throw new NullPointerException("Veiculo inválido!");
		}
		return buscarPlaca(placa);
	}

	public static void deletePlaca(String placa) {
		if (placa != null) {
			vDao.delete(placa);
		} else {
			throw new NullPointerException("Loja informada inválido!");
		}
	}

	public static List<Veiculo> buscarTodos(String nome) {

		return vDao.findAllLoja(nome);
	}
}
