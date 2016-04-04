package com.aljumaro.techtest.configuration;

import com.aljumaro.techtest.service.logging.EnvDependentService;
import com.aljumaro.techtest.service.logging.EnvDependentServiceImpl;
import com.aljumaro.techtest.service.logging.dev.EnvDependentServiceDevImpl;
import com.aljumaro.techtest.service.logging.prod.EnvDependentServiceProImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Date 03/04/2016
 * @Time 11:31
 * @Author Juanma
 */
@Configuration
public class EnvironmentConfiguration {

    /*Loading spring.profiles.active from PropertySource does not load before the Environment is set in the application
    initializiation. Therefore profile specific beans must be created in a configuration file like this and not by
    @ComponentScan.*/

    //NOTE: ALL BEANS MUST HAVE A DEFAULT IMPLEMENTATION

    //EnvDependentService by profile
    //DEFAULT PROFILE
    @Bean
    @Profile("default")
    public EnvDependentService getDefaultDependentService() {
        return new EnvDependentServiceImpl();
    }

    //DEV PROFILE
    @Bean
    @Profile("dev")
    public EnvDependentService getDevDependentService(){
        return new EnvDependentServiceDevImpl();
    }

    //PRO PROFILE
    @Bean
    @Profile("pro")
    public EnvDependentService getProDependentService(){
        return new EnvDependentServiceProImpl();
    }
}
