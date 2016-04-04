package com.aljumaro.techtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * PropertyConfiguration
 * Created by Juanma on 02/04/2016.
 */
@Configuration
@PropertySource(value = "file:${apps_config_path}/SpringBootHibernateWebAPI/application.properties", ignoreResourceNotFound = true)
public class PropertyConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
