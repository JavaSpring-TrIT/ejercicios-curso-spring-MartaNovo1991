package com.curso.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
<<<<<<< HEAD:ejerciciosEureka/src/main/java/com/curso/boot/SwaggerConfig.java
//Siguiente ejercicio documentacion:
=======
>>>>>>> 8e7f7e1cbd3a5813c334db138d5c11a7359bb02c:ejercicios/src/main/java/com/curso/boot/SwaggerConfig.java
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors
            .basePackage("com.curso.controller")).paths(PathSelectors.regex("/.*"))
        .build();
  }

}
