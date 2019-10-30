package com.heystyles.mail.api.service;


import com.heystyles.common.types.BaseResponse;
import com.heystyles.mail.core.Mail;

public interface MailService {

    BaseResponse encolarMail(Mail mail);

    void sendMail(Mail mail);

}
