package io.craigmiller160.pgtest.service

import io.craigmiller160.pgtest.domain.MessageRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessageService(
        private val messageRepo: MessageRepo
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun getMessage(): String {
        logger.info("Trying to find message in Postgres")
        return runCatching {
            val message = messageRepo.findAll().first().message
            logger.info("Message found: $message")
            message
        }
                .recover { ex ->
                    logger.error("Error getting message from Postgres", ex)
                    "Failed"
                }
                .getOrThrow()
    }
}