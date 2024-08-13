package sieun.chat.global.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class User(
    @Id
    var id: String,
    var password: String,
    var name: String,
    var image: String?
)
