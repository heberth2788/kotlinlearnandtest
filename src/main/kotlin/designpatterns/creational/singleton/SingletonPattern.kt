package com.bbs.designpatterns.creational.singleton

/***
 * Ensure that a class has only one instance
 * and provide global access point to this instance
 *
 * Utility : object to access to the database, or web services.
 */

/**
 * Option 1 : "object" declaration
 */
object SingletonPattern {
    var attr1: String = ""

    // The "init" method will execute after the main constructor,
    // so in this case the "object" declaration
    // don't allow to have the main constructor
    init {
        attr1 = "I'm the attribute 1"
    }

    fun doSomething() {
        println("My attr1 = $attr1")
    }
}

/**
 * Option 2 : Companion object
 */
class SingletonPatternUsingCompanionObject private constructor() {
    var attr1: String = ""

    fun doSomething() {
        println("My attr1 = $attr1")
    }

    companion object {
        private val singleton: SingletonPatternUsingCompanionObject by lazy {
            SingletonPatternUsingCompanionObject()
        }

        fun getInstance(): SingletonPatternUsingCompanionObject {
            return singleton
        }
    }
}

/**
 * Testing singleton
 */
fun useSingleton() {
    SingletonPattern.attr1 = "Heberth Deza"
    SingletonPattern.doSomething()

    val mySingleton = SingletonPatternUsingCompanionObject.getInstance()
    mySingleton.attr1 = "Lilian Martinez"
    mySingleton.doSomething()
}