package com.etiqa.management;

import org.springframework.context.annotation.Bean;

import java.util.Collections;


public class SwaggerConfig {

    /*@Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/etiqa/.*"))
                .build()
                .apiInfo(apiInfo());
    }*/

    /*private Predicate<String> postPath(){
        return or(regex("/etiqa/posts.*"), regex("/etiqa/.*"));
    }*/

    /*private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API ETIQA TEST")
                .description("API Doc for Etiqa Test Application")
                .version("1.0")
                .termsOfServiceUrl("http://terms-of-services.url")
                .license("LICENSE")
                .licenseUrl("http://url-to-license.com")
                .build();
    }*/

}
