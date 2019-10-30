package com.heystyles.mail.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
@Validated
@ConfigurationProperties("mail")
public class MailProperties {

    @NotNull
    private String defaultFromEmail;

    public String getDefaultFromEmail() {
        return defaultFromEmail;
    }

    public void setDefaultFromEmail(String defaultFromEmail) {
        this.defaultFromEmail = defaultFromEmail;
    }
}
