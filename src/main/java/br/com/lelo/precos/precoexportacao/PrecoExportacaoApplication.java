package br.com.lelo.precos.precoexportacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PrecoExportacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrecoExportacaoApplication.class, args);
	}

	@Bean
	public ObjectMapper createObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}

}
