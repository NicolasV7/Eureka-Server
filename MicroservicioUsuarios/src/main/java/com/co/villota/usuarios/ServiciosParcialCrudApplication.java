package com.co.villota.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan ({"com.co.villota.common.usuario.models.entity.*"})
@EnableJpaRepositories({"com.co.villota.common.usuario.models.entity.*"})
@EntityScan({"com.co.villota.common.usuario.models.entity.*"})
public class ServiciosParcialCrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiciosParcialCrudApplication.class, args);
	}

}
