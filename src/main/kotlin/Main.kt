package com.bbs

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import com.bbs.assessment.Assessment
import com.bbs.assessment.MyClassType
import com.bbs.designpatterns.creational.singleton.useSingleton
import kotlinx.coroutines.isActive

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main(): Unit = runBlocking {
    val amount: Double = 0.0
    println(amount.toString())
}

suspend fun doSomethingUsefulOne(): Int {
    delay(2000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(5000L) // pretend we are doing something useful here, too
    return 29
}
