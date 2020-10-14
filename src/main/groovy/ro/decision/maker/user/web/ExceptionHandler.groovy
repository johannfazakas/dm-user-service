package ro.decision.maker.user.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ro.decision.maker.user.transfer.ErrorOutput

import static org.springframework.http.HttpStatus.BAD_REQUEST

@ControllerAdvice
class ExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class)

    @Override
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info("handleMethodArgumentNotValid >> $ex")

        def error = ex.getBindingResult().getFieldError()
        ErrorOutput errorOutput = new ErrorOutput(
                message: "Invalid input",
                errorCode: "invalidInput",
                name: error.getField(),
                value: error.getRejectedValue(),
        )
        return handleExceptionInternal(ex, errorOutput, headers, BAD_REQUEST, request)
    }
}
