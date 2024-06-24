package com.bbs.assessment

/**
 * An interface is a 'Contract' and explain
 * 'what we can do for you' like a menu in a
 * restaurant.
 *
 * So the 'menu' is an 'interface' between the
 * 'restaurant' and the 'client' and viceversa.
 *
 * Many restaurants can 'implement' the same interface.
 */
interface MyInterface {
    val speed: Int
        get() = 0
    val maxSpeed: Int
        get() = 100

    fun startEngine()
    fun stopEngine()
    fun accelerate()
    fun brake()

    var name: String
    fun doSomething() {
        println("Doing something")
    }
}