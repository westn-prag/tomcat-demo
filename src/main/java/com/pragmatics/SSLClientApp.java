package com.pragmatics;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class SSLClientApp extends SpringBootServletInitializer {

    @Bean
    public RestTemplate template() throws Exception{
        RestTemplate template = new RestTemplate();
        return template;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SSLClientApp.class);
    }

    public static void main(String[] args) throws Exception {
        try {
            int x = 0/0;
        } catch (ArithmeticException e){
            logger.error("ERROR");
        }

        SpringApplication.run(SSLClientApp.class, args);
    }

    private void run(ApplicationArguments args) throws Exception {
        logger.info("Info Log");
    }

    private static final Logger logger = LogManager.getLogger(SSLClientApp.class);

}