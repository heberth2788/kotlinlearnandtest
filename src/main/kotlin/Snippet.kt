package com.bbs

class Snippet(
    val notNullAttribute: Int,
    val nullAttribute: Int? = null,
) {

    fun testingList(size: Int = 3) {
        println("\ntestingList")
        val myList = List(size) { it * 3 }
        println(myList)
    }

    fun testingSequence(seed: Int = 3, quantity: Int = 6) {
        println("\ntestingSequence")
        val seq: Sequence<Int> = generateSequence(seed) {
             it * 3
            // it + 3
        }.take(quantity)
        println(seq.toList())
    }
}