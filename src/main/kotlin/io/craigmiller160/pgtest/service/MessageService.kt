package io.craigmiller160.pgtest.service

import io.craigmiller160.pgtest.domain.MessageRepo
import org.springframework.stereotype.Service

@Service
class MessageService(
        private val messageRepo: MessageRepo
) {
    fun getMessage(): String =
            messageRepo.findAll().first().message
}