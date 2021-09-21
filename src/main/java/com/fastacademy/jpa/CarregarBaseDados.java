package com.fastacademy.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarregarBaseDados {

	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);
			
	@Bean
	CommandLineRunner initDatabase(RepositorioFuncionario repository) {
		return args ->{
			log.info("carregando" + repository.save(new Funcionario("Pedro Ivo","Anaista")));
			log.info("carregando" + repository.save(new Funcionario("Marias Clara","Consultor")));
		};
	}
}
