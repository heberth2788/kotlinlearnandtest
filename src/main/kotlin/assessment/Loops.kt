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

fun breakContinueReturnInLoops() {

    // return
    for (i in 1..9) {
        if (i == 6) return // return the function
        print(i) // 1, 2, 3, 4, 5
    }

    listOf(1, 2, 3, 4, 5, 6).forEach {
        if (it == 3) return // return the function
        print(it) // 1, 2
    }

    listOf(1, 2, 3, 4, 5, 6).forEach(
        action = fun(value: Int) {
            if (value in 2..5) return // return the internal function: fun(value: Int)
            print(value) // 1, 6
        }
    )

    // return using label
    listOf(1, 2, 3, 4, 5, 6).forEach firstForEach@ {
        if (it in 2..5) return@firstForEach // return the loop forEach
        print(it) // 1, 6
    }

    // break
    for (i in 1..9) {
        if (i == 6) break // break the loop
        print(i) // 1, 2, 3, 4, 5
    }

    for (i in 1..9) {
        print(i) // 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (j in 1..9) {
            if(j == 6) break // break the loop of 'j'
            print(j) // 1, 2, 3, 4, 5
        }
    }

    // break using label
    firstFor@ for (i in 1..9) {
        print(i) // 1
        for (j in 1..9) {
            if(j == 6) break@firstFor // break the loop of 'i'
            print(j) // 1, 2, 3, 4, 5
        }
    }

    // continue
    for (i in 1..9) {
        print(i) // 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (j in 1..9) {
            if (j in 2..8) continue
            print(j) // 1, 9
        }
    }


    // continue with label
    firstFor@ for (i in 1..9) {
        print(i) // 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (j in 1..9) {
            if (j == 3) continue@firstFor
            print(j) // 1, 2
        }
    }
}