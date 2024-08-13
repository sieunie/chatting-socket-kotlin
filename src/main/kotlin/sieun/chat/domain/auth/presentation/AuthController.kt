package sieun.chat.domain.auth.presentation

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
    fun signUp(@RequestBody authSignUpReq: AuthSignUpReq): ResponseEntity<String> {
        return authService.signUp(authSignUpReq)
    }

    @PostMapping("/signin")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "성공")
    )
    fun signIn(@RequestBody authSignInReq: AuthSignInReq): ResponseEntity<String> {
        return authService.signIn(authSignInReq)
    }
}