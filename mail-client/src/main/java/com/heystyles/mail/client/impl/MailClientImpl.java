package com.heystyles.mail.client.impl;

import com.heystyles.common.types.BaseResponse;
import com.heystyles.mail.client.MailClient;
import com.heystyles.mail.core.Mail;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class MailClientImpl implements MailClient {

    private final String urlBase;
    private final RestTemplate restTemplate;

    public MailClientImpl(String urlBase, RestTemplate restTemplate) {
        this.urlBase = urlBase;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendMail(Mail mail) {
        UriComponentsBuilder urlBuilder = UriComponentsBuilder
                .fromHttpUrl(urlBase)
                .pathSegment("controller");
        restTemplate.postForEntity(urlBuilder.toUriString(), mail, BaseResponse.class);
    }

    @Override
    public void sendMailImmediate(Mail mail) {
        UriComponentsBuilder urlBuilder = UriComponentsBuilder
                .fromHttpUrl(urlBase)
                .pathSegment("controller")
                .pathSegment("immediate");
        restTemplate.postForEntity(urlBuilder.toUriString(), mail, BaseResponse.class);
    }

}
