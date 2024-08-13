package sieun.chat.domain.auth.data.dto

data class AuthSignUpReq(
    val id: String,
    val password: String,
    val name: String
)
