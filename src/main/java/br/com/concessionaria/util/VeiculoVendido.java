package br.com.concessionaria.util;

public enum VeiculoVendido {
	
	Vendido(1),
	Disponivel(2);
	
	private int cod;
	
	private VeiculoVendido(int cod) {
		this.cod = cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public static VeiculoVendido valeuOf(int cod) {
		for(VeiculoVendido v : VeiculoVendido.values()) {
			if(cod == v.getCod()) {
				return v;
			}
		}
		throw new IllegalArgumentException("Opção inválido!");
	}
}
