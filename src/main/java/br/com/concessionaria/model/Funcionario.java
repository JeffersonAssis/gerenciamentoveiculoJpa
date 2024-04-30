package br.com.concessionaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "funcionarios")
@NamedQueries({
	@NamedQuery(name = "findByAll", query = "select f from Funcionario f"),
	@NamedQuery(name = "findByMatricula", query = "select f from Funcionario f join f.endereco where f.matricula =:matricula"),
	@NamedQuery(name = "findByNomeLojaAll", query = "select f from Funcionario f join Loja l on f.loja.id = l.id where l.nome Like :nome")
})
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String matricula;
	@ManyToOne
	@JoinColumn(name = "id_loja")
	private Loja loja;
	@OneToOne
	private Endereco endereco;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
