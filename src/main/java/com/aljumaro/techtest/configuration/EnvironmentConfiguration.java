package com.aljumaro.techtest.configuration;

import com.aljumaro.techtest.service.logging.LogginService;
import com.aljumaro.techtest.service.logging.LogginServiceImpl;
import com.aljumaro.techtest.service.logging.dev.LogginServiceDevImpl;
import com.aljumaro.techtest.service.logging.prod.LogginServiceProImpl;
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

    //DEFAULT PROFILE
    @Bean
    @Profile("default")
    public LogginService getDefaultLogginService() {
        return new LogginServiceImpl();
    }

    //DEV PROFILE
    @Bean
    @Profile("dev")
    public LogginService getDevLogginService(){
        return new LogginServiceDevImpl();
    }

    //PRO PROFILE
    @Bean
    @Profile("pro")
    public LogginService getProLogginService(){
        return new LogginServiceProImpl();
    }
}
