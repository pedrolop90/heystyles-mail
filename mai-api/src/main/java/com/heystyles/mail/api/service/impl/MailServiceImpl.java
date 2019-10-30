package com.heystyles.mail.api.service.impl;

import com.heystyles.common.exception.ValidationException;
import com.heystyles.common.types.BaseResponse;
import com.heystyles.common.util.UtilBase64;
import com.heystyles.common.util.UtilMail;
import com.heystyles.common.validation.ValidationError;
import com.heystyles.mail.api.config.MailProperties;
import com.heystyles.mail.api.exception.MailException;
import com.heystyles.mail.api.service.MailService;
import com.heystyles.mail.core.Attachment;
import com.heystyles.mail.core.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private MailProperties properties;

    @Override
    public void sendMail(Mail mail) {
        sendMailInternal(mail);
    }

    private void sendMailInternal(Mail mail) {
        try {
            List<String> correos = mail.getToAddresses();
            List<String> cc = mail.getCcAddresses();
            String asunto = mail.getSubject();
            String cuerpo = mail.getText();

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            for (String mailTo : correos) {
                if (!UtilMail.validateEmail(mailTo)) {
                    throw new ValidationException(new ValidationError("Correo TO invalido " + mailTo));
                }
                helper.addTo(mailTo);
            }

            if (cc != null && !cc.isEmpty()) {
                for (String mailCC : cc) {
                    if (!UtilMail.validateEmail(mailCC)) {
                        throw new ValidationException(new ValidationError("Correo CC invalido " + mailCC));
                    }
                    helper.addCc(mailCC);
                }
            }

            helper.setSubject(asunto);
            helper.setFrom(properties.getDefaultFromEmail());
            helper.setText(cuerpo, true);

            if (!CollectionUtils.isEmpty(mail.getAttachments())) {
                List<Attachment> adjuntos = mail.getAttachments();
                for (Attachment adj : adjuntos) {
                    String nombre = adj.getName();
                    String archivo = adj.getBase64();
                    if (!nombre.contains(".")) {
                        throw new IllegalArgumentException("El File debe de llevar la extension " + nombre);
                    }
                    byte[] bytes = UtilBase64.decode(String.valueOf(archivo));
                    helper.addAttachment(nombre, new ByteArrayResource(bytes));
                }
            }

            mailSender.send(message);
        }
        catch (MessagingException e) {
            throw new MailException(e);
        }
    }

    @Override
    public BaseResponse encolarMail(Mail request) {
        /*
        EncolarRequest encolarDto = new EncolarRequest();
        encolarDto.setCola(ColasEnum.MAILS);
        encolarDto.setMensaje(UtilJson.toString(request));
        return colasClient.encolar(encolarDto);
         */
        return null;
    }

}
