package br.com.concessionaria.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
@NamedQueries({
	@NamedQuery(name = "findByAllVenda", query = "select v from Venda v"),
	@NamedQuery(name = "findByVenda", query = "select v from Venda v join Veiculo a on v.veiculo.id = a.id where a.placa LIKE :placa"),
	@NamedQuery(name = "findByVendaCpf", query = "select v from Venda v join Cliente a on v.cliente.id = a.id where a.cpf LIKE :cpf"),
	@NamedQuery(name = "findByVendaNomeLoja", query = "SELECT v FROM Venda v join Funcionario f on f.id =v.funcionario.id JOIN Loja l ON v.funcionario.loja.id = l.id WHERE l.nome Like :nome")
})
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private float valor;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}
