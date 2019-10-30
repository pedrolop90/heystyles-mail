package com.heystyles.mail.api.controller;

import com.heystyles.common.response.Responses;
import com.heystyles.common.types.BaseResponse;
import com.heystyles.mail.api.service.MailService;
import com.heystyles.mail.core.Mail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/controller")
@RestController
@Api(value = "Mail Controller", description = "Controller para administración del envío de correos")
public class MailController {

    @Autowired
    private MailService service;

    @PostMapping
    @ApiOperation(value = "Envia un correo a un grupo de destinatarios y permite adjuntos de manera asincrona.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "El correo ha sido enviado exitosamente"),
            @ApiResponse(code = 201, message = "El correo ha sido enviado exitosamente"),
            @ApiResponse(code = 401, message = "No se encuentra autorizado"),
            @ApiResponse(code = 403, message = "El recurso se encuentra prohibido"),
            @ApiResponse(code = 404, message = "El recurso no ha sido encontrado"),
            @ApiResponse(code = 500, message = "Ocurrión un error, no se pudo enviar correo")

    })
    public ResponseEntity<BaseResponse> sendMail(@RequestBody @Valid Mail mail) {
        BaseResponse response = service.encolarMail(mail);
        return Responses.responseEntity(response);
    }

    @PostMapping("/immediate")
    @ApiOperation(value = "Envia un correo a un grupo de destinatarios y permite adjuntos inmediatamente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "El correo ha sido enviado exitosamente"),
            @ApiResponse(code = 201, message = "El correo ha sido enviado exitosamente"),
            @ApiResponse(code = 401, message = "No se encuentra autorizado"),
            @ApiResponse(code = 403, message = "El recurso se encuentra prohibido"),
            @ApiResponse(code = 404, message = "El recurso no ha sido encontrado"),
            @ApiResponse(code = 500, message = "Ocurrión un error, no se pudo enviar correo")

    })
    public ResponseEntity<BaseResponse> sendMailImmediate(@RequestBody @Valid Mail mail) {
        service.sendMail(mail);
        return Responses.successEntity("Enviado correctamente");
    }

}
