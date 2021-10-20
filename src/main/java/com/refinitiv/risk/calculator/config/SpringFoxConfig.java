package com.refinitiv.risk.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.service.Contact;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class  SpringFoxConfig implements WebMvcConfigurer {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.description}")
    private String appDesc;

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfo(appName, appDesc, "1.0", "", new Contact("Refinitive", "", "cd212343@gmail.com"), "", "",
                Collections.emptyList());
    }
    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.refinitiv.risk.calculator.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
    }
}
