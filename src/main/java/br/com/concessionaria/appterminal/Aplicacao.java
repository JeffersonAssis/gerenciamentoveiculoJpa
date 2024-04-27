package br.com.concessionaria.appterminal;

import java.sql.SQLException;

import br.com.concessionaria.menuterminal.Home;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		Home homeLoja = new Home();
		homeLoja.init();

	}

}
