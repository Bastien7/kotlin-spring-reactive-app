package com.bastien.model

import org.springframework.data.annotation.Id

/**
 * Created by bastien on 24/07/2017.
 */
data class Address(@Id val id: String? = null, val number: Int, val street: String, val city: String) {
    constructor() : this(null, 0, "", "") //TODO to replace with noarg plugin
    constructor(number: Int, street: String, city: String) : this(null, number, street, city)
}