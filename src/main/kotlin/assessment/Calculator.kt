package com.bbs.assessment

/**
 * Example of using Generics
 */
class Calculator {

    fun calculate(a: Int, b: Int, operation: String): Int {
        return when(operation) {
            "add" -> calc(a, b, ::add)
            "sub" -> calc(a, b, ::sub)
            else -> {
                throw IllegalArgumentException("Invalid operation")
            }
        }
    }

    // Functional programming with Generics
    private fun <T> calc(a: T, b: T, calc: (T, T) -> T): T {
        return calc(a, b)
    }

    private fun add(a: Int, b: Int): Int = a + b

    private fun sub(a: Int, b: Int): Int = a - b

    fun parse(str: String): Int {
        val (a, op, b) = str.split(" ")

        return calculate(a.toInt(), b.toInt(), op)
    }
}