package com.hepsiemlak.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebSecurityConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("payment",
						r -> r.path("/payment/**")
							  .uri("http://localhost:8081"))
				.route("package",
						r -> r.path(("/package/**")).and()
								.path("/subscription/**").and()
								.path("/usage/**")
								.uri("http://localhost:8082"))
				.route("user",
						r -> r.path("/user/**")
								.uri("http://localhost:8080"))
				.route("advert",
						r -> r.path("/advert/**")
								.uri("http://localhost:8083"))
				.route("notification",
						r -> r.path("/notification/**")
								.uri("http://localhost:8084"))
				.build();
	}

}
