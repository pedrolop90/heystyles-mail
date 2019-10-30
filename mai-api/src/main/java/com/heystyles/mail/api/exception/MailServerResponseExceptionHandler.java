package com.heystyles.mail.api.exception;

import com.heystyles.common.exception.ServerResponseExceptionHandler;
import com.heystyles.common.response.Responses;
import com.heystyles.common.types.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MailServerResponseExceptionHandler extends ServerResponseExceptionHandler {

    @ExceptionHandler({ MailException.class })
    public final ResponseEntity<Object> handleMailFailures(MailException ex, WebRequest request) {
        ErrorResponse error = Responses.error(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        return handleExceptionInternal(ex, error, new HttpHeaders(), error.getStatus(), request);
    }

}
