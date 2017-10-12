package com.ballistic.haleemghr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.Contact;
/**
 * Created by Nabeel on 10/10/2017.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ballistic.haleemghr.restApi"))
                .paths(regex("/print.*")).build().apiInfo(metaData());

    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Haleem Ghr REST API",
                "Haleem Ghr REST API for Online Store",
                "2.0",
                "Terms of service",
                new Contact("Nabeel Ahmed", "https://github.com/NABEEL-AHMED-JAMIL", "nabeel.amd93@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
