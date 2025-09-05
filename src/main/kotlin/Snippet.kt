package com.bbs

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Snippet(
    val notNullAttribute: Int = 0,
    val nullAttribute: Int? = null,
) {

    fun testSumList(
        intElement: Int,
        listA: List<Int>,
        listB: List<Int>,
    ) {
        val newList: List<Int> by lazy { listA + intElement + listB }
        println(newList)
    }

    //@Suppress("UNUSED_PARAMETER")
    private fun fooBar(throwable: Throwable) {
        if (throwable is CancellationException) return
        println("Everything is ok...")
    }

    fun testParseStringToUri() {
        val myUrlStr = "https://www.scotiabank.com.pe/Personas/agencias"
    }

    fun testingList(size: Int = 3) {
        println("\ntestingList")
        val myList = List(size) { it * 3 }
        println(myList)
        fooBar(Throwable("Throwable"))
    }

    fun testingSequence(seed: Int = 3, quantity: Int = 6) {
        println("\ntestingSequence")
        val seq: Sequence<Int> = generateSequence(seed) {
             it * 3
            // it + 3
        }.take(quantity)
        println(seq.toList())
    }

    suspend fun testReturnWithContext(): String = withContext(Dispatchers.Default) {
        val a: Int = 1988
        val b: Int = 2024
        val c: Int = 2025
        val d: Int = 1988

        return@withContext when(a) {
            b -> throw Exception()
            c -> throw Exception()
            d -> {
                val e: Int = a + b
                "d$e"
            }
            else -> throw Exception()
        }

        /*when(a) {
            b -> throw Exception()
            c -> throw Exception()
            d -> return@withContext "d"
            else -> throw Exception()
        }*/
    }
}