package eu.phamtheanh.gkg.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import java.util.NoSuchElementException

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException::class)
    fun noSuchElementExceptionHandler(): ModelAndView {
        return ModelAndView("exception")
                .addObject("status", HttpStatus.NOT_FOUND.value())
    }

    @ExceptionHandler(Exception::class)
    fun defaultExceptionHandler(): ModelAndView {
        return ModelAndView("exception")
                .addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value())
    }

}