package com.example.springboot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por habilitar o Swagger na aplicação.
 * <p>
 * A anotação @EnableSwagger2 — Responsavel em informar ao Spring Boot para ativar o Swagger.
 * A anotação @EnableWebMvc — Responsável por habilitar o processo MVC.
 *
 * @author Adriano Santos
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Metodo responsável por controlar e configurar os caminhos do Swegger e validar a url.
     * <a href="http://localhost:8080/swagger-ui.html">...</a>
     *
     * @param registry Objeto responsavel em receber e manipular os dados da configuracao do Swagger.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Primary
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

    /**
     * Metodo responsavel por definir os aspecitos dos endpoints expostos por ele.
     *
     * @return Retorna as configurações predefinidas e a url "/swagger-ui.html".
     */
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Metodo responsável por controlar, configurar e adicionar algumas informacoes da api.
     * @return Retorna as informacoes da api.
     */
    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title("Spring Boot REST API - Lista de Produtos e Usuários")
                .description("Um exemplo de aplicação Spring Boot REST API")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Adriano Santos", "https://github.com/Adriano1976", "adrianosantos.git@gmail.com"))
                .build();
    }
}


