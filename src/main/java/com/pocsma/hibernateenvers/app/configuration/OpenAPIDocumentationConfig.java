package com.pocsma.hibernateenvers.app.configuration;

import java.util.Arrays;
import java.util.TreeMap;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIDocumentationConfig {

    @Value("${server.servlet.context-path}")
	private String contextPath;
    
    private static final String BEARER = "TOKEN";
    
    @Bean
	OpenAPI customOpenAPI() {
		// define the apiKey SecuritySchema
		return new OpenAPI()
				.components(new Components()
				.addSecuritySchemes(BEARER, apiKeySecuritySchema()))
				.info(new Info().version("0.0.1").title("HistoryDB-POC")
				.description("RESTful services documentation with OpenAPI 3."))
				.security(Arrays.asList(new SecurityRequirement().addList(BEARER)))
				.addServersItem(new Server().url(contextPath));
	}
	
	public SecurityScheme apiKeySecuritySchema() {
		return new SecurityScheme()
				.name("Authorization")
				.description("Description about the TOKEN")
				.type(SecurityScheme.Type.HTTP)
				.bearerFormat("JWT")
				.scheme("bearer");
	}
	
	@Bean
	OpenApiCustomiser sortSchemasAlphabetically() {
	    return openApi -> {
	        @SuppressWarnings("rawtypes")
			java.util.Map<String, Schema> schemas = openApi.getComponents().getSchemas();
	        openApi.getComponents().setSchemas(new TreeMap<>(schemas));
	    };
	}

}
