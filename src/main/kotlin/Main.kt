package com.bbs

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import com.bbs.assessment.Assessment
import com.bbs.designpatterns.creational.singleton.useSingleton

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() = runBlocking {

   useSingleton()

    val mySnippet = Snippet(
        notNullAttribute = 1988,
        //nullAttribute = null,
    )

    println(mySnippet.nullAttribute)


    /*val encora = Encora()
    encora.doSomething()*/

    /*val assessment = Assessment()
    assessment.functionWithGenerics()*/

    //useSingleton()

    /*val assessment = Assessment()
    val list1 = arrayListOf<String>("Heberth", "Joel", "Deza", "Vasquez")
    val list2 = arrayListOf<String>("Lilian", "Joel", "Martinez", "Deza")
    val res = assessment.getDuplicatedStrings(list1, list2)
    res.forEach {
        print(it)
    }*/

    /*val time = measureTimeMillis {
        println("Another message 1")
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("Another message 2")
        println("The answer is ${one.await() + two.await()}")
        println("Another message 3")
    }
    println("Completed in $time ms")*/

    /*runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }*/

/*    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello $name")

    //TIP click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    // To <b>Run</b> code, press <shortcut actionId="Run"/> or
    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }*/

/*    val assess1 = Assessment()
    assess1.forInDoesNotAllowToChangePivot()
    assess1.forInToDisplayNumbers()
    assess1.listIteratorAndSet()
    assess1.usingHigherOrderFunction()
    assess1.loopUsingRange()
    assess1.tryingAsWithQuestionMark()
    assess1.tryingDoubleDotsOperator()
    assess1.tryingTriplesQuotes()
    assess1.testFibonacciSequence()
    assess1.tryingExtensionFunction()
    assess1.tryingSequenceYieldAll()
    assess1.tryingPrintlnWithInterpolation()
    assess1.testingAnyClass()
    Assessment.staticTestPivotMethod()*/

/*    val mySnippet = Snippet()
    mySnippet.testingList(6)
    mySnippet.testingSequence(quantity = 9, seed = 1)*/
}

fun test() {

}

suspend fun doSomethingUsefulOne(): Int {
    delay(2000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(5000L) // pretend we are doing something useful here, too
    return 29
}
