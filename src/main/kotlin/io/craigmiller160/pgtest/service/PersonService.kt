package io.craigmiller160.pgtest.service

import io.craigmiller160.pgtest.domain.PersonRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@Service
class PersonService(
        private val personRepo: PersonRepo
) {

    @PostConstruct
    @Transactional
    fun stuff() {
        GlobalScope.launch {
            val jobs = listOf(
                    async {
                        doChange(2000)
                    },
                    async {
                        doChange(4000)
                    }
            )
            jobs.awaitAll()
            println("Done")
        }
    }

    private suspend fun doChange(time: Long) {
        println("Doing change: $time ms")
        val person = withContext(Dispatchers.IO) {
            personRepo.findById(1L).get()
        }
        delay(time)
        val newPerson = person.copy(accountBalance = person.accountBalance - 10)
        withContext(Dispatchers.IO) {
            runCatching {
                personRepo.save(newPerson)
            }
                    .recover { ex ->
                        ex.printStackTrace()
                    }
        }
        println("Done with change")
    }
}