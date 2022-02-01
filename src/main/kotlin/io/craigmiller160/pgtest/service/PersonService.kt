package io.craigmiller160.pgtest.service

import io.craigmiller160.pgtest.domain.PersonRepo
import kotlinx.coroutines.Dispatchers
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
        runBlocking {
            launch {
                doChange(2000)
            }
            launch {
                doChange(4000)
            }
        }
    }

    private suspend fun doChange(time: Long) {
        val person = withContext(Dispatchers.IO) {
            personRepo.findById(1L).get()
        }
        delay(time)
        val newPerson = person.copy(accountBalance = person.accountBalance - 10)
        withContext(Dispatchers.IO) {
            personRepo.save(newPerson)
        }
    }
}