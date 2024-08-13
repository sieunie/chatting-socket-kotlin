package sieun.chat.domain.auth.data.dto

data class AuthSignUpReq(
    val email: String,
    val password: String,
    val name: String
)
