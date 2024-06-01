package com.bbs.assessment

/**
 * Example of using Generics
 */
class Calculator {

    fun calculate(a: Int, b: Int, operation: String): String {
        when(operation) {
            "add" -> return calc(a, b, ::add).toString()
            "sub" -> return calc(a, b, ::sub).toString()
            else -> {
                return "Something went wrong"
            }
        }
    }

    // Functional programming with Generics
    private fun <T> calc(a: T, b: T, calc: (T, T) -> T): T {
        return calc(a, b)
    }

    private fun add(a: Int, b: Int): Int = a + b
    private fun sub(a: Int, b: Int): Int = a - b
}