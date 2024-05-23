package com.bbs.assessment

class Encora {

    class MyIntArray: EncoraArray<Int>()
    class MyDoubleArray: EncoraArray<Double>()

    val myIntArray = MyIntArray()
    val myDoubleArray = MyDoubleArray()

    fun doSomething() {
        val num = 1988
        for(i in 0..11) {
            myIntArray.add(num + i)
        }
        println(myIntArray.toString())

        val numDouble = 1988.3
        for(i in 0..11) {
            myDoubleArray.add(numDouble + i)
        }
        println(myDoubleArray.toString())
    }
}

abstract class EncoraArray<T> {
    var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)

    private var index = 0

    fun add(element: T) {
        ensureCapacity()
        elements[index++] = element
    }

    private fun ensureCapacity() {
        if(index >= elements.size) {
            elements = elements.copyOf(elements.size * 2)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun getElement(i: Int): T {
        return elements[i] as T
    }

    override fun toString(): String {
        return elements.joinToString(separator = ",")
    }

    companion object {
        protected const val DEFAULT_CAPACITY = 10
    }
}




