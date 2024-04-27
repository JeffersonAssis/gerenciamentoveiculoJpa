package br.com.concessionaria.menuterminal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FrenteLoja {
	private Menu menu = new Menu();
	private Veiculos menuVeiculo = new Veiculos();
	private Lojas menuLoja = new Lojas();
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("FRENTE DE LOJA");
		opcoes.add("VEICULOS");
		opcoes.add("LOJAS");
		opcoes.add("VENDEDORES");
		opcoes.add("CLIENTES");
		opcoes.add("VENDAS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: menuVeiculo.init();
					break;
				case 1:  menuLoja.init();
					break;
				case 2:  System.out.println("***** Chama menu VENDEDOR ******"); //subMenuVendedor();
					break;
				case 3:  System.out.println("***** Chama menu CLIENTES ******"); //subMenuCliente();
					break;
				case 4:  System.out.println("***** Chama menu VENDAS ******"); //subMenuVendas();
					break;
				case 5: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
}
