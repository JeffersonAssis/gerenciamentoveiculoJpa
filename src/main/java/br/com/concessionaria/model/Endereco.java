package br.com.concessionaria.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
@NamedQueries({
	@NamedQuery(name = "findByCep", query = "select e from Endereco e where e.cep =:cep"),
    @NamedQuery(name = "removeCep", query = "Delete from Endereco e where e.cep = :cep")
})


public class Endereco implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 12, unique = true)
	private String cep;
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false, name ="cidade")
	private String localidade;
	
	@Column(nullable = false)
	private String uf;
	@Column(nullable = false)
	private String complemento;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCiade() {
		return localidade;
	}
	public void setCiade(String ciade) {
		this.localidade = ciade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", uf=" + uf + ", complemento=" + complemento + "]";
	}

}
