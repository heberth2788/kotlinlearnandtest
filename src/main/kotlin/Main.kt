package com.bbs

import com.bbs.assessment.InterviewQuestions
import com.bbs.assessment.MyEnumClass
import kotlinx.coroutines.delay
import java.util.regex.Pattern

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() { //: Unit = runBlocking {

//    val rpta: Boolean = InterviewQuestions.isAnagramV2("anagram", "magranaa")
//    println("\nAnagram ? : $rpta")

//    val mrc: Char = InterviewQuestions.getMostRepeatedChar("ddaanrooi")
//    println("\nThe most repeated character ? : $mrc")

//    val rov: String = InterviewQuestions.reserverOnlyVowelsV2("androIde")
//    println("\n Reversed only vowels : $rov")

    val result: List<Int> = InterviewQuestions.evenNumbersThenOddNumbers(listOf(4, 5, 6, 1, 2, 3))
    print("\nEven numbers then odd numbers : ")
    result.forEach {
        print("$it,")
    }

/*    val s = Snippet()
    s.testSumList(intElement = 1988, listA = listOf(1, 2, 3), listB = listOf(4, 5, 6))

    val p = Pattern.compile("a*b")
    val m = p.matcher("b")
    val b = m.matches()

    val amount: Double = 1988.9
    val a = fooBar3(amount)

    val amountStr = String.format("%.2f", 1988.toDouble())

    println(a)

    println("START")
    firstFor@ for (i in 1..9) {
        println(i) // 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (j in 1..9) {
            if (j == 3) continue@firstFor
            print(j) // 1, 2
        }
        println()
    }
    println("\nEND")*/

  /*  val myAo = ArithmeticOperator()
    myAo.useTimes()
    println('h' * 3)

    MyClass().forEachTest()

    myAo.useDiv()
    myAo.useRem()
    myAo.usePlus()
    myAo.useMinus()

    val myPoint = ArithmeticOperator.Point(x = 1, y = 2)
    myPoint(param1 = 1988, param2 = "HD") // call 'invoke' function

    val myObj = MyCoroutineTest()
    println("main start: ${ Thread.currentThread().name }")

    myObj.myRunBlocking()
    myObj.myLaunch()
    myObj.myLaunchV2()
    myObj.myLaunchV3()
    myObj.myAsync()

    println("main end: ${ Thread.currentThread().name }")*/
}

fun fooBar(amount: Double): String {
    val strAmount: String = amount.toString()
    val parts = strAmount.split(".")
    return if (parts[1].toDouble() == 0.0) {
        parts[0]
    } else {
        strAmount
    }
}

fun fooBar2(amount: Double): String {
    val intPart: Int = amount.toInt()
        val decimalPart: Double = amount - intPart
        return if (decimalPart != 0.0) {
            amount.toString()
        } else {
            intPart.toString()
    }
}

fun fooBar3(amount: Double): String = String.format("%.2f", amount)

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
