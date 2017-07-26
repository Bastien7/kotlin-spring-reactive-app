package com.bastien.model

import org.springframework.data.annotation.Id

/**
 * Created by bastien on 24/07/2017.
 */
data class Person(@Id val id: String? = null, val name: String, val age: Int, val address: Address) {
    constructor() : this(null, "", 0, Address()) //TODO to replace with noarg plugin
    constructor(name: String, age: Int, address: Address) : this(null, name = name, age = age, address = address)
}