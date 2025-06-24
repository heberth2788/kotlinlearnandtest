package com.bbs

import com.sun.jndi.toolkit.url.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Snippet(
    val notNullAttribute: Int,
    val nullAttribute: Int? = null,
) {

    fun testParseStringToUri() {
        val myUrlStr = "https://www.scotiabank.com.pe/Personas/agencias"
    }

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