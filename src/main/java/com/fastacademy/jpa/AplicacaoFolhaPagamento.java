package com.fastacademy.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoFolhaPagamento {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoFolhaPagamento.class, args);
		new CarregarBaseDados();
	}

}
