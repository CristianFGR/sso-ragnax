package com.ragnax.ssorepositorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ragnax.ssorepositorio.configuration.FactoryApiProperties;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(FactoryApiProperties.class)
@EntityScan({"com.ragnax.domain.sso.entidad"})
public class SSORepositorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSORepositorioApplication.class, args);
	}

}
