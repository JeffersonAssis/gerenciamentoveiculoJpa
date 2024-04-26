package br.com.concessionaria.service;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;

import br.com.concessionaria.model.Endereco;

public class ViaCep {

	public static Endereco buscarCep(String cep) {
		 Endereco end = new Endereco();
		try {
		
		String url = "https://viacep.com.br/ws/"+cep+"/json";
		
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.of(1, MINUTES))
				.build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
	            .GET()
	            .uri(URI.create(url))
	            .build();
		
		HttpResponse<String> httpResponse = httpClient.send(
				httpRequest, HttpResponse.BodyHandlers.ofString());
		
		if (httpResponse.statusCode() == 200) {
            Gson gson = new Gson();
            end = gson.fromJson(httpResponse.body(), Endereco.class);

            } else {
            System.out.println("Erro ao obter os dados do CEP. Código de status: " + httpResponse.statusCode());
        }
    
		
		}catch (Exception e) {
			// TODO: handle exception
		}
			return end;
		
		
	}
}
