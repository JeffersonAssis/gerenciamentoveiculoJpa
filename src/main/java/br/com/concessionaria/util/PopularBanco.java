package br.com.concessionaria.util;

import java.util.Locale;

import org.hibernate.query.hql.LiteralConsumer;

import com.github.javafaker.Faker;

import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.service.ClienteService;
import br.com.concessionaria.service.EnderecoService;
import br.com.concessionaria.service.FuncionarioSevice;

public class PopularBanco {
	
	
	static Faker j = new Faker();
	
	public static void main(String[] args) {
		
		Carro();
	}
	
	public static void popularPessoa() {
		
		for(int i = 0; i<15 ; i++) {
			//Cliente c = new Cliente()
			Funcionario c = new Funcionario();
			Endereco end = new Endereco();
			Loja l = new Loja();
			c.setNome(j.name().fullName());
			c.setCpf(j.code().isbn10(false)+"3");
			c.setNumResidencia(""+j.number().numberBetween(13, 1313));
			c.setMatricula(""+j.number().numberBetween(133, 1000));
			end.setLogradouro(j.address().streetName());
			end.setCep(j.address().zipCode().replace("-", ""));
			end.setComplemento(j.address().secondaryAddress());
			end.setCiade(j.address().city());
			end.setUf(j.address().state());
			end.setBairro(j.address().cityName());
			l.setId(+j.number().numberBetween(3, 6));
			c.setEndereco(end);
			c.setLoja(l);
			
			
		}
	}
	
	public static void Carro() {
		
		
		for(int i = 0 ; i< 40 ;i++) {
			var vehicle = Faker.instance();
			
		}
	}
	
	
}
