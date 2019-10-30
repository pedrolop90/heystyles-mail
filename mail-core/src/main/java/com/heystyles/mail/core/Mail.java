package com.heystyles.mail.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mail {

    @NotNull
    @NotEmpty
    private List<String> toAddresses;

    private List<String> ccAddresses;

    private List<Attachment> attachments;

    @NotNull
    private String subject;

    @NotNull
    private String text;

    public List<String> getToAddresses() {
        return toAddresses;
    }

    public void addToAddress(String address) {
        if (toAddresses == null) {
            toAddresses = new ArrayList<>();
        }
        toAddresses.add(address);
    }

    public void setToAddresses(List<String> toAddresses) {
        this.toAddresses = toAddresses;
    }

    public List<String> getCcAddresses() {
        return ccAddresses;
    }

    public void addCcAddress(String address) {
        if (ccAddresses == null) {
            ccAddresses = new ArrayList<>();
        }
        ccAddresses.add(address);
    }

    public void setCcAddresses(List<String> ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void addAttachment(Attachment attachment) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment);
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
