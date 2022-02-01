package io.craigmiller160.pgtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PgTestApplication

fun main(args: Array<String>) {
	runApplication<PgTestApplication>(*args)
}
