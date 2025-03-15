package com.bbs.assessment

fun forWhileAndDoWhileLoops() {
    val myList: List<Int> = listOf(1, 2, 3, 4, 5, 6)

    for (i: Int in myList) { // for (i in myList)
        println(i) // 1, 2, 3, 4, 5, 6
    }

    for ((index: Int, value: Int) in myList.withIndex()) { // for ((index, value) in myList.withIndex())
        println("[$index]=$value") // [0]=1, [1]=2, [2]=3, [3]=4, [4]=5, [5]=6
    }

    for (i: Int in 1..6) { // for (i in 1..6)
        println(i) // 1, 2, 3, 4, 5, 6
    }

    for (i: Int in 1..<6) { // for (i in 1..<6)
        println(i) // 1, 2, 3, 4, 5
    }

    for (i: Int in 1 until 6) { // for (i in 1 until 6)
        println(i) // 1, 2, 3, 4, 5
    }

    for (i: Int in 1..6 step 2) { // for (i in 1..6 step 2)
        println(i) // 1, 3, 5
    }

    for (i: Int in 6 downTo 1) { // for (i in 6 downTo 1) {
        println(i) // 6, 5, 4, 3, 2, 1
    }

    for (i: Int in 6 downTo 0 step 2) {  // for (i in 6 downTo 0 step 2)
        println(i) // 6, 4, 2, 0
    }

    myList.forEach { i: Int -> // myList.forEach { println(it) }
        println(i) // 1, 2, 3, 4, 5, 6
    }

    var i: Int = 6
    while (i > 0) {
        println(i--) // 6, 5, 4, 3, 2, 1
    }

    i = 6
    do {
        println(i--) // 6, 5, 4, 3, 2, 1
    } while (i > 0)
}