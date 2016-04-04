package com.aljumaro.techtest.configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @Date 03/04/2016
 * @Time 21:19
 * @Author Juanma
 */
@Component
public class LogConfiguration {
    public final static Logger LOG = LoggerFactory.getLogger(LogConfiguration.class);
    public final static String LOGGING_CONFIGURATION = "/SpringBootHibernateWebAPI/logback.xml";

    @PostConstruct
    public void configureLogBack() {

        LOG.info("Configuring logback with external file");

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            loggerContext.reset();
            configurator.doConfigure(new File(System.getProperty("apps_config_path") + LOGGING_CONFIGURATION));

        }catch(JoranException je) {
            //StatusPrinter handles this
        }

        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);

        LOG.info("LogBack reStarted");

    }
}
