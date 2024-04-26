package br.com.concessionaria.service;

import br.com.concessionaria.dao.impl.EnderecoDAO;
import br.com.concessionaria.model.Endereco;

public class EnderecoService {
	
	static EnderecoDAO endDao = new EnderecoDAO();
	
	private static void save(String cep) {
		Endereco end = new Endereco();
		if(cep.length() == 8) {
			end = ViaCep.buscarCep(cep);
			if(!end.getCep().isEmpty()) {
				end.setCep(cep);
				endDao.save(end);
			}else {
				throw new NullPointerException("Não foi possivel salvar o registro!");
			}
			
		}else 
			throw new NullPointerException("CEP informado inválido!");
	}
	
	public static Endereco buscarCep(String cep) {
		Endereco end = new Endereco();
		
		if(cep.length() == 8) {
			try {
			end = endDao.findByCep(cep);
			 if (end.getCep()!=null){
				return end;
			}
		}catch (Exception e) {
			System.out.println("Endereco não Cadastrado!");
			save(cep);
		}
		}else {
			throw new NullPointerException("CEP informado inválido!");
		}
		return buscarCep(cep);	
		
	}
	public static void deleteCep(String cep) {
		
		if(cep.length()==8) {
			endDao.deleteCep(cep);
		}else {
			throw new NullPointerException("CEP informado inválido!");
		}
		
	}
}
