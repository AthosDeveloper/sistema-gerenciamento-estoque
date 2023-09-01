package com.catalisa.sistemaEstoque;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sistema Estoque", version = "1", description = "api para gerenciar os produtos no estoque. Ler, cadastrar, atualizar e deletar"))
public class SistemaEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEstoqueApplication.class, args);
	}

}
