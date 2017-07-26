package com.bastien.repository

import com.bastien.model.Person
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

/**
 * Created by bastien on 24/07/2017.
 */
interface PersonRepository : ReactiveMongoRepository<Person, String> {
    fun findPersonByAge(age: Int): Flux<Person>
    fun findPersonByAddressCity(city: String): Flux<Person>
    fun findPersonByAgeAndAddressCity(age: Int, city: String): Flux<Person>
}
