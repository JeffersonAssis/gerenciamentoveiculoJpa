package br.com.concessionaria.util;

public enum TipoVeiculos {
	
	CICLOMOTOR(0),
	MOTONETA(1),
	MOTOCICLETA(2),
	TRICICLO(3),
	QUADRICICLO(4),
	AUTOMOVEL(5),
	MICROONIBUS(6),
	ONIBUS(7),
	COMINHONETE(8),
	CAMINHAO(9);
	
	
	private int cod;
	
	private TipoVeiculos(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}
	
	public static TipoVeiculos valeuOf(int cod) {
		for(TipoVeiculos v : TipoVeiculos.values()) {
			if(cod == v.getCod()) {
				return v;
			}
		}
		throw new IllegalArgumentException("Tipo de Veiculo inválido!");
	}
}
