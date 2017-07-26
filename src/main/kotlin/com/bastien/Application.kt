package com.bastien

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringReactiveAppApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringReactiveAppApplication::class.java, *args)
}
