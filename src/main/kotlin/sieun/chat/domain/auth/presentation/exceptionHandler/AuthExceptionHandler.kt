package sieun.chat.domain.auth.presentation.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import sieun.chat.domain.auth.presentation.AuthController
import java.util.NoSuchElementException

@RestControllerAdvice(basePackageClasses = [AuthController::class])
class AuthExceptionHandler {

    @ExceptionHandler(NoSuchElementException::class)
    fun authNoSuchElementExceptionHandler(): ResponseEntity<String> {
        return ResponseEntity("사용자 정보가 없습니다.", HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun authIllegalArgumentExceptionHandler(): ResponseEntity<String> {
        return ResponseEntity("이메일이 중복됩니다.", HttpStatus.BAD_REQUEST)
    }
}