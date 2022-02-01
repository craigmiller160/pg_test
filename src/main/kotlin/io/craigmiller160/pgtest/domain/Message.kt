package io.craigmiller160.pgtest.domain

import javax.persistence.*

@Entity
@Table(name = "message")
data class Message(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val message: String
)
