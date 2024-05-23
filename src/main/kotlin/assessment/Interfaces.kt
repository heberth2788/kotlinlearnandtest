package com.bbs.assessment

interface Interfaces {
    val speed: Int
        get() = 0
    val maxSpeed: Int
        get() = 100

    fun startEngine()
    fun stopEngine()
    fun accelerate()
    fun brake()
}