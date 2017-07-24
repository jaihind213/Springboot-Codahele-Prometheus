package org.jaihind213.learn.spring;

/**
 * Hello world!
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring app
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.jaihind213.learn.spring"})
public class App extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        logger.info("Sample App starting...");
        SpringApplication.run(App.class, args);
    }

}