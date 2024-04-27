package br.com.concessionaria.menuterminal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoCadastro {
private Menu menu = new Menu();
private Veiculos menuVeiculo = new Veiculos();
private Lojas menuLojas = new Lojas();
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("MANUTENCAO DE CADASTRO");
		opcoes.add("GERENCIAR VEICULOS");
		opcoes.add("GERENCIAR LOJA");
		opcoes.add("GERENCIAR VENDEDOR");
		opcoes.add("GERENCIAR CLIENTE");
		opcoes.add("GERENCIAR VENDAS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: menuVeiculo.initGerenciar();
					break;
				case 1:  menuLojas.initGerenciar();
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
