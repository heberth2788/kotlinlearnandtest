package com.bbs

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import com.bbs.assessment.MyEnumClass
import com.bbs.coroutine.MyCoroutineTest
import com.bbs.operatoroverloading.ArithmeticOperator
import com.bbs.operatoroverloading.times

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() { //: Unit = runBlocking {

    val myAo = ArithmeticOperator()
//    myAo.useTimes()
    println('h' * 3)

//    myAo.useDiv()
//    myAo.useRem()
//    myAo.usePlus()
//    myAo.useMinus()

//    val myPoint = ArithmeticOperator.Point(x = 1, y = 2)
//    myPoint(param1 = 1988, param2 = "HD") // call 'invoke' function

//    val myObj = MyCoroutineTest()
//    println("main start: ${ Thread.currentThread().name }")

    //myObj.myRunBlocking()
    //myObj.myLaunch()
    //myObj.myLaunchV2()
    //myObj.myLaunchV3()
//    myObj.myAsync()

//    println("main end: ${ Thread.currentThread().name }")
}

fun testingWhen() {
    val myEnumObj: MyEnumClass = MyEnumClass.BERTHLY
    when(myEnumObj) {
        MyEnumClass.LILIAN -> println("Wife")
        MyEnumClass.HEILY, MyEnumClass.JOICY, MyEnumClass.BERTHLY -> println("Daugthers")
        //MyEnumClass.HEBERTH -> println("Me")
        else -> println("Unknown")
    }
}

suspend fun doSomethingUsefulOne(): Int {
    delay(2000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(5000L) // pretend we are doing something useful here, too
    return 29
}
