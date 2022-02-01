package io.craigmiller160.pgtest.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepo : JpaRepository<Message,Long>