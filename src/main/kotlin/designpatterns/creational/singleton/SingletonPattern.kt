package com.bbs.designpatterns.creational.singleton

/***
 * Ensure that a class has only one instance
 * and provide global access point to this instance
 */

/**
 * Option 1 : "object" declaration
 */
object SingletonPattern {
    var attr1: String = ""
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