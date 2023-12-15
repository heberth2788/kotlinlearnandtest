package com.bbs.assessment

class Assessment {
    /**
     * Question 1: Why the compiler not allow the value of "y" to change?
     *
     * Answer: "y" is an implicit immutable value. E.g: "val y: Int"
     * */
    fun forInAssessment() {
        for(y in 1..100) {
            print("$y ")
        }
    }


}