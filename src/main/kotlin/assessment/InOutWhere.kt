package com.bbs.assessment

/**
 * Generics: in(input), out(output), where(specify constraints)
 *
 * E.g.:
 *  Generic type: LinkedList<E>
 *  Parameterized type: LinkedList<Int> or LinkedList<String>
 *  Type Argument: Int or String
 */
class InOutWhere {

    /**
     * Generics: Using generics in a class, to use type parameters
    */
    class Box<T>(t: T) {
        var value = t
    }
    val myBox1: Box<String> = Box<String>("HD")
    val myBox2 = Box<String>("JD")
    val myBox3 = Box("HD") // Compiler figures out that it is: Box<String>("HD")
    val myBox4 = Box(1988) // Compiler figures out that it is: Box<Int>(1988)

    /**
     * In: means "input", it is used as a parameter type
     */
    class WriteAndReadA<in T>(
        private var value: T,
    ) {
        fun setT(newValue: T) { value = newValue } // Good

        // fun getT(): T = value // Error: T is not allowed as a return type (out)
    }

    /**
     * Out: means "output", it is used as a returned type
     */
    class ReadAndWriteB<out T>(
        private var value: T,
    ) {
        fun getT(): T = value // Good

        // fun setT(newValue: T) { value = newValue } // Error: T is not allowed as an input type (in)
    }

    /**
     * Where: to describe restrictions (Or additional information) for generics
     * It can use as argument (in) or return type (out)
     */
    interface Processor<T> where T: CharSequence, T: Comparable<T> {
        fun processInput(value: T)
        fun processOutput(): T
    }

    class StringProcessor: Processor<String> {

        override fun processInput(value: String) {
            print("Hello $value")
        }

        override fun processOutput(): String {
            return "HD"
        }
    }
}