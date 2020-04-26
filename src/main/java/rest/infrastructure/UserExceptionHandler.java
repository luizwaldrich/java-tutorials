package rest.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {

    private Logger log = LoggerFactory.getLogger(UserExceptionHandler.class);

    private MessageSource messageSource;

    public UserExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private class UserError {
        private String code;
        private String message;

        public UserError(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    @ResponseBody
    @ExceptionHandler(UserException.UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundExceptionHandler(UserException e) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new UserError(e.code, getMessage(e.code, e.msgParameters)));
        log.error(json);
        return ResponseEntity.status(e.status).body(json);
    }

    @ResponseBody
    @ExceptionHandler(UserException.UserBusinessException.class)
    public ResponseEntity<String> userBusinessExceptionHandler(UserException e) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new UserError(e.code, getMessage(e.code, e.msgParameters)));
        log.error(json);
        return ResponseEntity.status(e.status).body(json);
    }

    @ResponseBody
    @ExceptionHandler(UserException.UserInvalidPayloadException.class)
    public ResponseEntity<String> userInvalidPayloadExceptionHandler(UserException e) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new UserError(e.code, getMessage(e.code, e.msgParameters)));
        log.error(json);
        return ResponseEntity.status(e.status).body(json);
    }

    private String getMessage(String messageKey, String[] parameters) {
        return messageSource.getMessage(messageKey, parameters, LocaleContextHolder.getLocale());
    }
}
