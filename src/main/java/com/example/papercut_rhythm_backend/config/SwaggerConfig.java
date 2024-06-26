package com.example.papercut_rhythm_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// swagger2 可自行修改
@Configuration
@EnableSwagger2   //开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.papercut_rhythm_backend.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //配置swagger信息=apiinfo
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("纸韵剪影")
                .description("纸韵剪影接口")
                .version("1.0")
                .build();
    }
}
