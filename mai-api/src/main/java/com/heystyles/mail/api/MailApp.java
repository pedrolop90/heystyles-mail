package com.heystyles.mail.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {
        "com.heystyles.mail.api.async",
        "com.heystyles.mail.api.config",
        "com.heystyles.mail.api.controller",
        "com.heystyles.mail.api.service",
        "com.heystyles.mail.api.exception",
})
@EnableScheduling
@SpringBootApplication
public class MailApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MailApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MailApp.class, args);
    }

}
