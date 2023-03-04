package com.github.xiaoymin.knife4j.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/4 21:55
 * @since:knife4j-openapi3-spring-webflux-demo
 */
@Configuration
public class WebFluxKnife4jConfig {

    @Bean
    public GroupedOpenApi tweetsOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = { "/tweets/**" };
        return GroupedOpenApi.builder().
                group("tweets")
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Tweets API").version(appVersion)))
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi streamOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = { "/stream/**" };
        String[] packagedToMatch = { "org.springdoc.demo.app3" };
        return GroupedOpenApi.builder().group("x-stream")
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Stream API").version(appVersion)))
                .pathsToMatch(paths).packagesToScan(packagedToMatch)
                .build();
    }

}
