package br.com.concessionaria.view;

import java.util.List;

import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.service.VeiculoService;

public class Teste {
	
	public static void main(String[] args) {
		Loja l = new Loja();
		l.setNome("Loja de Carros recife");
		
		
		/*
		
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
		List<Veiculo> vv = VeiculoService.buscarTodos("Loja de Carros loja02");
		
		for(Veiculo v : vv)
			System.out.println(v.getPlaca()+" Modelo "+ v.getModelo()+" "+v.getLoja().getNome());
	
	
	
	}
}
