package sieun.chat.domain.auth.application

import org.springframework.http.ResponseEntity
import sieun.chat.domain.auth.data.dto.AuthSignInReq
import sieun.chat.domain.auth.data.dto.AuthSignUpReq

interface AuthService {
    fun signUp(authSignUpReq: AuthSignUpReq): ResponseEntity<String>
    fun signIn(authSignInReq: AuthSignInReq): ResponseEntity<String>
}