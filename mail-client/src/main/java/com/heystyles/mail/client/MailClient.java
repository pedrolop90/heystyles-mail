package com.heystyles.mail.client;


import com.heystyles.mail.core.Mail;

public interface MailClient {

    void sendMail(Mail mail);

    void sendMailImmediate(Mail mail);

}
