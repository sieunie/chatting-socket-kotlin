package sieun.chat.domain.auth.application.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import sieun.chat.domain.auth.application.AuthService
import sieun.chat.domain.auth.data.dto.AuthSignInReq
import sieun.chat.domain.auth.data.dto.AuthSignUpReq
import sieun.chat.global.config.jwt.JwtTokenProvider
import sieun.chat.global.entity.User
import sieun.chat.global.repository.UserRepository

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passWordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
): AuthService {
    override fun signUp(authSignUpReq: AuthSignUpReq): ResponseEntity<String> {
        if (userRepository.existsByEmail(authSignUpReq.email))
            throw IllegalArgumentException()

        userRepository.save(User(
            email = authSignUpReq.email,
            password = passWordEncoder.encode(authSignUpReq.password),
            name = authSignUpReq.name,
            image = null
        ))

        return ResponseEntity(jwtTokenProvider.createAccessToken(authSignUpReq.email), HttpStatus.OK)
    }

    override fun signIn(authSignInReq: AuthSignInReq): ResponseEntity<String> {
        val user = userRepository.findById(authSignInReq.email)
        if (!passWordEncoder.matches(authSignInReq.password, user.get().password))
            throw NoSuchElementException()

        return ResponseEntity(jwtTokenProvider.createAccessToken(authSignInReq.email), HttpStatus.OK)
    }
}