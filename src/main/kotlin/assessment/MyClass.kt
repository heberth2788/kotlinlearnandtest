package com.bbs.assessment

abstract class MyArray<T: Number> {
    private var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)
    private var index = 0

    fun <T> add(element: T) {
        ensureCapacity()
        elements[index++] = element
    }

    private fun ensureCapacity() {
        if(index >= elements.size) {
            elements = elements.copyOf(elements.size * 2)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getElement(i: Int): T {
        return elements[i] as T
    }

    override fun toString(): String {
        return elements.joinToString(separator = ",")
    }

    companion object {

        const val DEFAULT_CAPACITY = 10
    }
}

class MyIntArray: MyArray<Int>()
class MyDoubleArray: MyArray<Double>()

class MyClass {

    private val myIntArray = MyIntArray()
    private val myDoubleArray = MyDoubleArray()

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

    fun forEachTest() {
        val listA = listOf(1, 2, 3, 4, 5, 6)
        val listB = listOf(4, 5, 6, 7, 8, 9)

        println("Example 1:")
        listA.forEach la@{ a ->
            print("\na=$a, ")
            listB.forEach lb@{ b->
                print("b=$b, ")
                if (a == b) {
                    return@la
                }
            }
        }
        println("Finish\n")

        println("Example 2:")
        listA.forEach la@{ a ->
            print("\na=$a, ")
            listB.forEach lb@{ b->
                print("b=$b, ")
                if (a == b) {
                    return@lb
                }
            }
        }
        println("Finish\n")

        println("Example 3:")
        listA.forEach la@{ a ->
            print("\na=$a, ")
            listB.forEach lb@{ b->
                print("b=$b, ")
                if (a == b) {
                    println("Finish\n")
                    return
                }
            }
        }
    }
}

interface A {

    val myValue: Int

    fun fooBar()

    fun barFoo() {
        print("abc")
    }
}

class B : A {

    override val myValue = 1988

    override fun fooBar() {
        barFoo()
    }
}