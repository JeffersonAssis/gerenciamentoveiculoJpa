package br.com.concessionaria.menuterminal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Veiculos {

	private Menu menu = new Menu();

	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("VEICULOS");
		opcoes.add("BUSCAR VEICULO POR PLACA OU MODELO");
		opcoes.add("LISTAR TODOS OS VEICULOS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);

		boolean loop = true;
		while (loop) {
			int op;
			op = menu.getMenu();
			switch (op) {
				case 0:
					getModeloPlaca();
					break;
				case 1:
					getAll();
					break;
				case 2:	loop = false;
					break;
				default:
					System.err.println("A opção informada é Invalida!");
			}
		}
	}

	public void initGerenciar() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("GERENCIAR VEICULOS");
		opcoes.add("CADASTRAR VEICULO");
		opcoes.add("ALTERAR VEICULO");
		opcoes.add("REMOVER VEICULO");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);

		boolean loop = true;
		while (loop) {
			int op;
			op = menu.getMenu();
			switch (op) {
			case 0:
				setVeiculo();
				break;
			case 1:
				updateVeiculo();
				break;
			case 2:
				deleteVeiculo();
				break;
			case 3:
				System.out.println("Programa encerrado..");
				loop = false;
				break;
			default:
				System.err.println("A opção informada é Invalida!");
			}
		}
	}

	public void getAll() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}

	public void getModeloPlaca() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}

	public void setVeiculo() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}

	public void updateVeiculo() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}

	public void deleteVeiculo() throws SQLException {
		System.err.println("Falta implementar o SERVICE e a logica de JEFFERSON");
	}
}
