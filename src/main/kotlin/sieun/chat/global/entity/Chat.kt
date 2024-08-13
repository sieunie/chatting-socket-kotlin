package sieun.chat.global.entity

import jakarta.persistence.*

@Entity
data class Chat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    @ManyToOne
    var sender: User,
    @ManyToOne
    var chatRoom: ChatRoom,
    var text: String,
    var checked: Boolean = false
)
