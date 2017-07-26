package com.bastien.service

import com.bastien.model.Address
import com.bastien.model.Person
import com.bastien.repository.PersonRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

/**
 * Created by bastien on 24/07/2017.
 */
@Component
class PersonService(val personRepository: PersonRepository) {
    companion object {
        val cities = listOf("Luxembourg", "Metz", "Bettembourg").toLower()
        val streets = listOf("Royal street", "Station road").toLower()

        private fun List<String>.toLower() = this.map { it.toLowerCase() }
    }

    fun find(age: Int?, rawCity: String?): Flux<Person> {
        val city = rawCity?.toLowerCase()

        val flux: Flux<Person> = when {
            age is Int && city is String -> personRepository.findPersonByAgeAndAddressCity(age, city)
            city is String -> personRepository.findPersonByAddressCity(city)
            age is Int -> personRepository.findPersonByAge(age)
            else -> personRepository.findAll()
        }

        return flux
    }

    fun generateData(): Flux<Person> {
        val personList = listOf(10, 45, 23, 28, 34).map { generatePerson(it) }
        val deleteMono = personRepository.deleteAll()
        val personFlux = deleteMono.thenMany(personRepository.saveAll(personList)) //Here we chain a Flux to the deleteAll Mono

        return personFlux
    }

    /**
     * Generate a single data.
     */
    private fun generatePerson(age: Int): Person {
        val address = Address(age * 3, streets[age % streets.size], cities[age % cities.size])
        return Person("dude$age", age, address)
    }
}