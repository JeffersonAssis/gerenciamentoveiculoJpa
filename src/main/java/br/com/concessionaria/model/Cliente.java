package br.com.concessionaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
@NamedQueries({
	@NamedQuery(name = "findCpf", query = "select c from Cliente c where c.cpf =:cpf"),
	@NamedQuery(name = "findByCpf", query = "select c from Cliente c join c.endereco where c.cpf =:cpf")
})
public class Cliente extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String telefone;
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Cliente() {
		super();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
