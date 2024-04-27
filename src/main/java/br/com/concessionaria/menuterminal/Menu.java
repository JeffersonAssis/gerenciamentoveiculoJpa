package br.com.concessionaria.menuterminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String nome;
	private List<String> opcoes = new ArrayList<>();
	
	public Menu(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(List<String> opcoes) {
		this.opcoes = opcoes;
	}
	
	public int getMenu() {	
		Scanner sc = new Scanner(System.in);
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ "+ this.nome +" ################");
			int cont = 0;
			for (String opcao : opcoes) {
				System.out.println("["+ cont +"] - " + opcao);
				cont ++;
			}
			System.out.println("__________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = sc.nextInt();  sc.nextLine();
			
			for(int i=0; i <= opcoes.size(); i++) {				
				if(op == i){
					return i;				
				}else {
					if(i == opcoes.size()) {
						System.err.println("A opção informada é Invalida!");
					}
				}
			}
			
			// #SIMULANDO UM SWITCH CASE PARA PECORRER UMA LISTA DE METODOS DE FORMA DINAMICA
			/*  
			for(int i=0; i <= opcoes.size(); i++) {				
				if(op == i && op < opcoes.size() ){
					System.out.println("Selecionou => " + opcoes.get(i));
					break;				
				}else if(op == opcoes.size()-1) {
					System.err.println("Saindo do menu....");
					loop = false;
					break;
				}else {
					if(i == opcoes.size()) {
						System.err.println("A opção informada é Invalida!");
					}
				}
			}
			*/
		}
		return -1;	
	}
}