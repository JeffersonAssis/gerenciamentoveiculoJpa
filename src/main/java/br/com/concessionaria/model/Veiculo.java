package br.com.concessionaria.model;

import java.io.Serializable;

import br.com.concessionaria.util.TipoVeiculos;
import br.com.concessionaria.util.VeiculoVendido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
@NamedQueries({
	@NamedQuery(name = "findByPlaca", query = "select v from Veiculo v where v.placa=:placa"),
	@NamedQuery(name = "findByModelo", query = "select v from Veiculo v WHERE v.modelo LIKE :modelo and v.vendido=2"),
	@NamedQuery(name = "findByVeiculoNomeLoja", query = "SELECT v FROM Veiculo v JOIN Loja l on v.loja.id = l.id WHERE ( v.vendido = 2 and l.nome LIKE :nome) ")
})
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true, length = 7)
	private String placa;
	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private String marca;
	private int ano;
	@Column(scale = 2)
	private double valor;
	private int vendido;
	private int tipoVeiculo;
	@ManyToOne
	@JoinColumn(name = "id_loja")
	private Loja loja;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoVeiculos getTipoVeiculo() {
		return TipoVeiculos.valeuOf(tipoVeiculo);
	}

	public void setTipoVeiculo(TipoVeiculos tipoVeiculo) {
		if(tipoVeiculo != null) {
			this.tipoVeiculo = tipoVeiculo.getCod();
		}
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public VeiculoVendido getVendido() {
		return VeiculoVendido.valeuOf(vendido);
	}

	public void setVendido(VeiculoVendido vendido) {
		if(vendido != null) {
			this.vendido = vendido.getCod();
		}
	}

}
