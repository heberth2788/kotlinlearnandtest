package com.bbs.scopefunctions

data class Person(
    var name: String = "",
    var age: Int = 0,
    var city: String = ""
)

fun scopeFunctionsExample() {

    // let: Execute a code block with an object reference as "it"
    val person = Person()
    person.let {
        it.name = "John"
        it.age = 25
        println("let: ${it.name} is ${it.age} years old")
    }

    // run: Execute a code block with an object reference as "this"
    person.run {
        name = "Alice"
        age = 30
        println("run: $name is $age years old")
    }

    // with: Execute a code block with an object reference as "this" (non-extension function)
    with(person) {
        name = "Bob"
        age = 35
        city = "New York"
        println("with: $name is $age years old and lives in $city")
    }

    // apply: Configure object and return it (this)
    val newPerson = Person().apply {
        name = "Carol"
        age = 28
        city = "London"
    }
    println("apply: Created ${newPerson.name}")

    // also: Execute actions on object and return it (it)
    person.also {
        it.name = "David"
        it.age = 40
        println("also: Modified ${it.name}'s age to ${it.age}")
    }
}
