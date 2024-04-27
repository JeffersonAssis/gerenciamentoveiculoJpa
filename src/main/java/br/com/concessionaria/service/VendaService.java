package br.com.concessionaria.service;

import java.util.List;

import br.com.concessionaria.dao.impl.VendaDAO;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Venda;
import br.com.concessionaria.util.VeiculoVendido;

public class VendaService {

	static final VendaDAO vDao = new VendaDAO();

	public static void save(Venda c) {
		
		if (c.getValor()>0) {
			
			Cliente cli = ClienteService.buscarCpf(c.getCliente().getCpf());
			Funcionario fun = FuncionarioSevice.buscarMatricula(c.getFuncionario().getMatricula());
			Veiculo ve = VeiculoService.buscarPlaca(c.getVeiculo().getPlaca());
			c.setCliente(cli);
			c.setFuncionario(fun);
			ve.setVendido(VeiculoVendido.Vendido);			
			c.setVeiculo(ve);
			VeiculoService.VendaVeiculo(c.getVeiculo().getPlaca(),ve);
			
			if (!c.getVeiculo().getPlaca().isEmpty() && !c.getFuncionario().getMatricula().isEmpty() && !c.getCliente().getCpf().isEmpty())
					
				vDao.save(c);
		} else {
			throw new NullPointerException("Informações incompletas!");
		}
	}

	public static Venda buscarVendaPlaca(String placa) {
		if (placa != null) {
			return vDao.findByString(placa);
		} else {
			throw new NullPointerException("Venda não realizada!");
		}
	}

	
	public static void deleteVenda(String placa) {
		Venda v = buscarVendaPlaca(placa);
		Veiculo veiculo = VeiculoService.buscarPlaca(placa);
		veiculo.setVendido(VeiculoVendido.Disponivel);
		if (v != null) {
			VeiculoService.VendaVeiculo(placa , veiculo);
			vDao.deleteString(v);
		} else {
			throw new NullPointerException("Venda informada inválido!");
		}
	}

	public static List<Venda> buscarTodasVendaLoja(String nome) {

		return vDao.findAll(nome);
	}
}
