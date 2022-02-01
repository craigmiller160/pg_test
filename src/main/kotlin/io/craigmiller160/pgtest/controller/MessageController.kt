package io.craigmiller160.pgtest.controller

import io.craigmiller160.pgtest.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(
        private val messageService: MessageService
) {
    @GetMapping(produces = ["text/plain"])
    fun getMessage(): String =
            messageService.getMessage()
}