package br.com.concessionaria.view;

import java.util.List;

import org.hibernate.event.internal.DefaultResolveNaturalIdEventListener;

import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Venda;
import br.com.concessionaria.service.VeiculoService;
import br.com.concessionaria.service.VendaService;

public class Teste {
	
	public static void main(String[] args) {
		
		try {
		List<Venda> vv= VendaService.buscarTodasVendaLoja("Loja de Carros loja02");
		
		for(Venda v : vv)
			System.out.println(v.getValor()+" - "+v.getCliente().getNome()+" - "+v.getFuncionario().getMatricula()+" - "+v.getVeiculo().getPlaca()+" -"+v.getVeiculo().getTipoVeiculo());
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
		/*
		Veiculo vv = new Veiculo();
		vv.setPlaca("PCZ2244");
		Cliente cl = new Cliente();
		cl.setCpf("08745414417");
		Funcionario fun = new Funcionario();
		fun.setMatricula("456");
		Venda venda = new Venda();
		
		venda.setCliente(cl);
		venda.setFuncionario(fun);
		venda.setVeiculo(vv);
		venda.setValor(22000);
		
		
		VendaService.save(venda);
		
		
	Veiculo v = new Veiculo();
		v.setAno(2014);
		v.setLoja(l);
		v.setMarca("Fiat");
		v.setModelo("Uno");
		v.setPlaca("PCZ2211");
		v.setValor(15000.0);
		v.setTipoVeiculo(TipoVeiculos.AUTOMOVEL);
		v.setVendido(VeiculoVendido.Disponivel);
		VeiculoService.save(v);
	*/
	//	List<Veiculo> vvv = VeiculoService.buscarTodos("Loja de Carros loja02");
		
	//	for(Veiculo v : vvv)
		//	System.out.println(v.getPlaca()+" Modelo "+ v.getModelo()+" "+v.getLoja().getNome());
	
	
	
	}
}
