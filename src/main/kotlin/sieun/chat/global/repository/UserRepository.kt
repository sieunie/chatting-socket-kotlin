package sieun.chat.global.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sieun.chat.global.entity.User

@Repository
interface UserRepository: JpaRepository<User, String> {
}