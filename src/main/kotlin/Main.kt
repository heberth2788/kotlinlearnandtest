package com.bbs

import com.bbs.assessment.Assessment

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
//    val name = "Kotlin"
//    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//    // to see how IntelliJ IDEA suggests fixing it.
//    println("Hello $name")
//
//    //TIP click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//    // To <b>Run</b> code, press <shortcut actionId="Run"/> or
//    for (i in 1..5) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        println("i = $i")
//    }

    val assess1 = Assessment()
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

//    Assessment.staticTestPivotMethod()
}