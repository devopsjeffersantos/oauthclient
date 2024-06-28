package com.example.oauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OauthclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthclientApplication.class, args);
	}

	@Bean
	RouteLocator gateway(RouteLocatorBuilder rlb) {
		return rlb.routes()
				.route(produtos -> produtos.path("/api/produtos**").filters(GatewayFilterSpec::tokenRelay).uri("http://localhost:8081")).build();
				
	}
	
	@Bean
	RouteLocator gateway2(RouteLocatorBuilder rlb2) {
		return rlb2.routes()
				.route(clientes -> clientes.path("/api/clientes**").filters(GatewayFilterSpec::tokenRelay).uri("http://localhost:8082")).build();
	}
	
	
	@Bean
	RouteLocator gateway3(RouteLocatorBuilder rlb3) {
		return rlb3.routes()
				.route(pedidos -> pedidos.path("/api/pedidos**").filters(GatewayFilterSpec::tokenRelay).uri("http://localhost:8083")).build();
	}
	
	@Bean
	RouteLocator gateway4(RouteLocatorBuilder rlb4) {
		return rlb4.routes()
				.route(entregas -> entregas.path("/api/entregas**").filters(GatewayFilterSpec::tokenRelay).uri("http://localhost:8084")).build();
	}
	
	
	@Bean
	RouteLocator gateway5(RouteLocatorBuilder rlb5) {
		return rlb5.routes()
				.route(pagamentos -> pagamentos.path("/api/pagamentos**").filters(GatewayFilterSpec::tokenRelay).uri("http://localhost:8085")).build();
	}
	
	

}



