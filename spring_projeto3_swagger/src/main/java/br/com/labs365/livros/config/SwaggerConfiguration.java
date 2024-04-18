package br.com.labs365.livros.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                 .build()
                 .useDefaultResponseMessages(false);
    }
    private ApiInfo getApiInfo() {
                 return new ApiInfoBuilder()
                 .title("Livros API")
                 .description("API de Demonstração")
                 .contact(new Contact("John Snow", "www.livros.com", "john@livros.com"))
                 .version("1.0")
                 .build();
                 }
}
