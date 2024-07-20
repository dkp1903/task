/*******************************************************************************
 * Copyright 2020 rantidev.singh1@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.publicissapient.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Class to provide configuration for Open Api Specification (previously
 * mentioned as swagger). Whenever there are code changes in this application
 * specification/documentation will be automatically updated. EnableSwagger2
 * indicates that Swagger support should be enabled .
 *
 * @author Rantidev Singh
 * @version 1.0
 * @since 2020-10-01
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    /**
     * After the Docket bean is defined, its select() method returns an instance of
     * ApiSelectorBuilder, which provides a way to control the end points exposed by
     * Swagger. Predicates for selection of RequestHandlers can be configured with
     * the help of RequestHandlerSelectors and PathSelectors. Using any() for both
     * will make documentation for your entire API available through Swagger
     *
     * @return Docket
     */
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.publicissapient.weather.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * apiInfo method sets the custom information about the API.
     *
     * @return ApiInfo
     */
    public ApiInfo apiInfo() {
        return new ApiInfo("Diff API", "Rest API to get weather forcast for a city from OpenWeatherMap api ", "v1",
                "TERMS OF SERVICE URL",
                new Contact("Rantidev Singh", "", "rantidev.singh1@gmail.com"), "LICENSE",
                "LICENSE URL", Collections.emptyList());
    }
}
