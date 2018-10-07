package cz.levinzonr.CopsBoot.exceptions

import cz.levinzonr.CopsBoot.domain.models.FiledErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class RestControllerExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(exception: MethodArgumentNotValidException) : Map<String, List<FiledErrorMessage>> {
        return error(exception
                .bindingResult
                .fieldErrors
                .map { FiledErrorMessage(it.field, it.defaultMessage ?: "Unkwond") }
                .toList())
    }


    private fun error(errors: List<FiledErrorMessage>) : Map<String, List<FiledErrorMessage>> {
        return mapOf("errors" to errors)
    }

}