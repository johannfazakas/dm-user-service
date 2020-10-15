package ro.decision.maker.user.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ro.decision.maker.user.exception.DuplicateException
import ro.decision.maker.user.exception.NotFoundException
import ro.decision.maker.user.transfer.ErrorOutput

import static org.springframework.http.HttpStatus.*

@ControllerAdvice
class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class)

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    ErrorOutput handleNotFound(NotFoundException exception) {
        log.warn("handleNotFound >> ${exception}")

        new ErrorOutput(message: exception.message, errorCode: "notFound")
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseBody
    @ResponseStatus(CONFLICT)
    ErrorOutput handleDuplicate(DuplicateException exception) {
        log.warn("handleDuplicate >> ${exception}")

        new ErrorOutput(message: exception.message, errorCode: "duplicate")
    }


    @Override
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("handleMethodArgumentNotValid >> $ex")

        def error = ex.getBindingResult().getFieldError()
        ErrorOutput errorOutput = new ErrorOutput(
                message: "Invalid input",
                errorCode: "invalidInput",
                name: error.getField(),
                value: error.getRejectedValue(),
        )
        handleExceptionInternal(ex, errorOutput, headers, BAD_REQUEST, request)
    }
}
