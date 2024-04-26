package br.com.concessionaria.util;

public enum TipoVeiculos {
	
	CICLOMOTOR(1),
	MOTONETA(2),
	MOTOCICLETA(3),
	TRICICLO(4),
	QUADRICICLO(5),
	AUTOMOVEL(6),
	MICROONIBUS(7),
	ONIBUS(8),
	COMINHONETE(9),
	CAMINHAO(0);
	
	
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
