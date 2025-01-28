package com.bbs.assessment

class MyClassHd(val greeting: String) {

    operator fun invoke(name: String) {
        println(message = "$greeting $name")
    }
}

fun testMyInvokeFunction() {
    val myObj = MyClassHd(greeting = "Hello")
    myObj(name = "Heberth") // Use of invoke method
}