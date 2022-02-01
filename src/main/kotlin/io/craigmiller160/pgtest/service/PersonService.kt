package io.craigmiller160.pgtest.service

import io.craigmiller160.pgtest.domain.PersonRepo
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
        val person = personRepo.findById(1L).get();
        val newPerson = person.copy(accountBalance = person.accountBalance - 10)
        personRepo.save(newPerson)
    }
}