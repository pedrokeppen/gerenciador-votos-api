package com.teste.sicredi.gerenciador.votos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
public class GerenciadorVotosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorVotosApiApplication.class, args);
	}

}
