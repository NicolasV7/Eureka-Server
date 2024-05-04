package com.villota.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({ "com.villota.common.usuario.entity" })
@EnableDiscoveryClient
@EnableJpaRepositories({ "com.villota.common.usuario.entity" })
@EntityScan({ "com.villota.common.usuario.entity" }) 
@SpringBootApplication
public class MicroservicioSpringCursoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSpringCursoApplication.class, args);
	}
}
