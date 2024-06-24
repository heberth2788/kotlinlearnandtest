package com.bbs.designpatterns.creational.builder

interface MyBuilder {
    fun reset()
    fun setSeats(seatsNumber: Int)
    fun setEngine(engine: MyEngine)
    fun setTripComputer()
    fun setGps()
}

interface MyEngine