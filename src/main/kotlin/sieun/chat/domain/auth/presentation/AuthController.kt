package sieun.chat.domain.auth.presentation

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sieun.chat.domain.auth.application.AuthService
import sieun.chat.domain.auth.data.dto.AuthSignInReq
import sieun.chat.domain.auth.data.dto.AuthSignUpReq

@RestController
@RequestMapping("/api/auth")
@Tag(name = "인증")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/signup")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "성공")
    )
    fun signUp(authSignUpReq: AuthSignUpReq): ResponseEntity<String> {
        return authService.signUp(authSignUpReq)
    }

    @GetMapping("/signin")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "성공")
    )
    fun signIn(authSignInReq: AuthSignInReq): ResponseEntity<String> {
        return authService.signIn(authSignInReq)
    }
}