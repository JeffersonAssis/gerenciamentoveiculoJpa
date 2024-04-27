package br.com.concessionaria.menuterminal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Home {
	private Menu menu = new Menu();
	private FrenteLoja menuFrenteLoja = new FrenteLoja();
	private ManutencaoCadastro menuManutCadastro = new ManutencaoCadastro();
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("BEM VINDO");
		opcoes.add("FRENTE DE LOJA");
		opcoes.add("MANUTENCAO DE CADASTRO");
		opcoes.add("ENCERRAR PROGRAMA");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: menuFrenteLoja.init();
					break;
				case 1:  menuManutCadastro.init();
					break;
				case 2:System.out.println("Programa encerrado.."); loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}

}
