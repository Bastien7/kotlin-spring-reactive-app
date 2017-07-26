package com.bastien.controller

import com.bastien.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by bastien on 25/07/2017.
 */
@RestController
@RequestMapping("/api")
class PersonController(val personService: PersonService) {
    @GetMapping("/find")
    fun find(@RequestParam age: Int?, @RequestParam city: String?) = personService.find(age, city)

    @GetMapping("/generateData")
    fun generateDate() = personService.generateData()
}