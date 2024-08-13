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
        if (userRepository.existsById(authSignUpReq.id))
            throw IllegalArgumentException()

        userRepository.save(User(
            id = authSignUpReq.id,
            password = passWordEncoder.encode(authSignUpReq.password),
            name = authSignUpReq.name,
            image = null
        ))

        return ResponseEntity(jwtTokenProvider.createAccessToken(authSignUpReq.id), HttpStatus.OK)
    }

    override fun signIn(authSignInReq: AuthSignInReq): ResponseEntity<String> {
        val user = userRepository.findById(authSignInReq.id)
        if (!passWordEncoder.matches(authSignInReq.password, user.get().password))
            throw NoSuchElementException()

        return ResponseEntity(jwtTokenProvider.createAccessToken(authSignInReq.id), HttpStatus.OK)
    }
}