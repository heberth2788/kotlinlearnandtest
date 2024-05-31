package com.bbs.assessment

import com.bbs.internalpackage.InternalClass

class Assessment {
    /**
     * Question 1: Why the compiler not allow the value of "y" to change?
     *
     * Answer: Because "y" is an implicit immutable value. E.g: "val y: Int"
     * */
    fun forInDoesNotAllowToChangePivot() {
        println("\nforInDoesNotAllowToChangePivot")
        for(y in 1..100) {
            print("$y ")
        }
    }

    /**
     * Question 2: You have created a class that should be visible only to the other code in its module.
     *              Which modifier do you use?: internal, public, protected, private
     *
     * Answer: "internal", visible inside the same module
     * */
    private val internalObjA = InternalClass()
    internal val internalObjB = InternalClass()
    // val internalObjC = InternalClass() // This gives an error

    /**
     * Question 3: How do you fill in the blank below to display all of the even
     *              numbers from 1 to 10 with the least amount of code?
     *
     * Answer: for(count in 1..10) println("There are $count butterflies.")
     * */
    fun forInToDisplayNumbers() {
        println("\n\nforInToDisplayNumbers")
        for(count in 1..10) {
            println("There are $count butterflies.")
        }
    }

    /**
     * Question 4: which function changes the value of the element at the current iterator
     *              location?: set(), assign(), modify(), change()
     *
     * Answer: .set() , previous .next() of a ListIterator or MutableListIterator
     * */
    fun listIteratorAndSet() {
        println("\nlistIteratorAndSet")
        val listA: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        println(listA)

        val mlIterator: MutableListIterator<Int> = listA.listIterator()
        println(mlIterator.next())
        mlIterator.set(11)
        println(listA)

        /**
         * Other functions: .remove(), .removeAt(), .add()
         * */
        listA.remove(element = 6)
        println(listA)
        listA.removeAt(index = 4)
        println(listA)
        listA.add(index = 4, element = 55)
        listA.add(index = 5, element = 66)
        listA.add(88)
        println(listA)

        /**
         * EXTRAS: [], .set() and .forEach{}
         * */
        listA[2] = 33
        listA.set(3, 44)
        println(listA)
        listA.forEach {
            print("$it ")
        }
    }

    /**
     * Question 5: What is a higher-order function in kotlin?
     *
     * Answer: A higher-order function is a function that takes a function as
     *          a parameter, or return a function.
     * */
    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R,
    ): R {
        var accumulator: R = initial
        for(element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    fun usingHigherOrderFunction() {
        println("\n\nusingHigherOrderFunction")
        val myList = listOf(1, 2, 3, 4, 5, 6)
        val value = myList.fold(initial = 0) { acc, i ->
            val result = acc + i
            result
        }
        println(value)
    }

    /**
     * Question 6: Which code snippet correctly shows a for loop using
     *              a range to display "1 2 3 4 5 6" ?
     *
     * Answer: for(z in 1..6) print("$z ")
     * */
    fun loopUsingRange() {
        println("\nloopUsingRange")
        for(z in 1..6) print("$z ")
    }

    /**
     * Question 7: Your code needs to try casting an object. If the cast is not possible,
     *              you do not want an exception generated. Instead, you want null to be
     *              assigned, which operator can safely cast a value?
     *
     * Answer: as?
     * */
    fun tryingAsWithQuestionMark() {
        println("\n\ntryingAsWithQuestionMark")
        val auxStr: Any = 123
        val aux = auxStr as? Int
        print(aux)
    }

    /**
     * Question 8: The kotlin .. operator can be written as which
     *              function?: a.rangeTo(b), a.to(b), a.range(b), a.from(b)
     *
     * Answer: .rangeTo()
     * */
    fun tryingDoubleDotsOperator() {
        println("\n\ntryingDoubleDotsOperator")
        val rangeAux: IntRange = 1..6
        for(x in rangeAux) {
            print("$x ")
        }

        println()
        val auxNum = 1
        val rangeAux2: IntRange = auxNum.rangeTo(6)
        for(x in rangeAux2) {
            print("$x ")
        }
    }

    /**
     * Question 9: You'd like to create a multiline string that includes a carriage return character.
     *              What should you use to enclose the string?: "", """, `, '
     *
     * Answer: """ (Triples quotes)
     * */
    fun tryingTriplesQuotes() {
        println("\n\ntryingTriplesQuotes")
        val strAux = """ 
             This is my
             new string
             in multiples
             lines. HD.
        """
        println(strAux)
    }

    /**
     * Question 10: This function generates Fibonacci sequence. Which function is
     *              missing?: return(), yield(), with(), skip()
     *
     * Answer: yield()
     * */
    private fun fibonacci() = sequence { // Sequence created from "chunks"(trozos).
        var params = Pair(0, 1)
        while (true) {
            /**
             * yield() return an element to the sequence consumer and suspend the execution
             * of sequence() until the next element is requested by the consumer.
             * */
            yield(params.first)
            params = Pair(params.second, params.first + params.second)
        }
    }

    fun testFibonacciSequence() {
        println("\ntestFibonacciSequence")
        val fibSeq = fibonacci().take(6)
        println(fibSeq.toList())
    }

    /**
     * Question 11: Inside an "extension function", what is the name of the variable that
     *              corresponds to the receiver object?: this, receiver, default, it
     *
     * Answer: this
     * */
    fun tryingExtensionFunction() { // Principal function that contains a nested function
        println("\ntryingExtensionFunction")
        /**
         * Extension function
         * */
        fun MutableList<Int>.swap(index1: Int, index2: Int) { // It is also a nested function
            val tmp = this[index1] // Not recommended: this.get(index1)
            this[index1] = this[index2]
            this[index2] = tmp
        }
        val mutList = mutableListOf(1, 2, 3)
        mutList.swap(0, 2) // Calling the extension function ".swap()"
        println(mutList)
    }

    /**
     * Question 12: The code below is expected to display the number from 1 to 10,
     *              but it does not. Why?
     *
     * Answer: To produce results, a sequence must have a terminal operation, like .toList()
     * */
    fun tryingSequenceYieldAll() {
        println("\n\ntryingSequenceYieldAll")
        val seq = sequence {
                yieldAll(1..20)
        }.filter { it < 11 }
        // println(seq) // This DOES NOT print the values of the sequence.
        println(seq.toList()) // This prints the values of the sequence
    }

    /**
     * Question 13: The code below compiles and executes without issue, but is not idiomatic Kotlin.
     *              What is a better way to implement the println()?
     *
     * Answer: Use "string template" (Also called as "string interpolation")
     * */
    fun tryingPrintlnWithInterpolation() {
        println("\n\ntryingPrintlnWithInterpolation")
        val name: String = "Amos"
        val grade: Float = 95.5f
        println("My name is " + name + ". I scored " + grade + " points on the last coding quiz.") // DOES NOT recommend
        println("My name is $name. I scored $grade points on the last coding quiz.") // Recommended
    }

    /**
     * Question 14: All classes in Kotlin inherit from which superclass?: Object, Any, Super, Default
     *
     * Answer: Any (As Object in Java)
     * */
    fun testingAnyClass(): Unit { // "Unit" is in Kotlin as "void" is in Java.
        println("\ntestingAnyClass")
        val aux: Any = 123
        val myInt = aux as? Int // "as?" will return null is it cannot cast
        println(myInt)
    }

    /**
     * Question 15: What is the difference between the declarations of COLOR and SIZE?
     *
     * Answer: Both are immutable, but the use of the keyword "const" makes COLOR faster
     *          and more space efficient than SIZE.
     * */
    companion object {

        const val COLOR = "Red"
        val SIZE = "Large"

        fun staticTestPivotMethod() {
            println("\n\nstaticTestPivotMethod")
            val sum = generateSequence(seed = 1) { // Starting value
                it + 3      // nextFunction
            }.take(3)    // 3 times: pos0 -> 1, pos1 -> (1 + 3) = 4, pos2 -> (4 + 3) = 7
                .sum()         // 1 + 4 + 7 = 12
            println(sum)
        }
    }

    /**
     * Using generics in functions
     */
    fun functionWithGenerics() {
        /**
         * Function with generics
         */
        fun <T1, T2> ifNotNull(
            value1: T1,
            value2: T2,
            doSomething: (T1, T2) -> Unit,
        ) {
            if(value1 != null && value2 != null)
                doSomething(value1, value2)
            else
                println("One or both values are null")
        }

        val valueA: String? = "HD"
        val valueB: String? = "LM"
        ifNotNull(valueA, valueB) {
            valueA, valueB -> print("Both values are not null : $valueA , $valueB")
        }
    }

    /**
     * Using Set data structure
     */
    fun getDuplicatedStrings(
        list1: List<String>,
        list2: List<String>,
    ): List<String> {
        val list1Set = list1.toMutableSet()
        val result: MutableList<String> = mutableListOf()
        list2.forEach {
            if (!list1Set.add(it)) {
                result.add(it)
            }
        }
        return result.toList()
    }

    /**
    * Using Map data structure
    **/
    fun getMostRepeatedChar(str: String) : Char {
        val sortedStr = str.toCharArray().sorted()
        val dataStruct = mutableMapOf<Char, Int>()

        var cont = 0
        var charRet = ' '

        var i = 0
        while (i < sortedStr.size) {
            dataStruct[sortedStr[i]] = (dataStruct.getOrDefault(sortedStr[i], 0) as Int) + 1
            if ((dataStruct[sortedStr[i]] as Int) > cont) {
                cont = (dataStruct.get(sortedStr[i]) as Int)
                charRet = sortedStr[i]
            }
            i++
        }
        return charRet
    }
}

class Deivor : MySealedClass(birthYear = 2024)




