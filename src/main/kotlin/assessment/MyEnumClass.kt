package com.bbs.assessment

import java.time.Year

/**
 * An enum class is used to define different values
 * that can have a variable
 */
enum class MyEnumClass(
    val birthYear: Int,
) {

    HEBERTH(birthYear = 1988) {
        override fun fetchName(): String {
            return "HD"
        }
    },

    LILIAN(birthYear = 1987) {
        override fun fetchName(): String {
            return "LM"
        }
    },

    BERTHLY(birthYear = 2024) {
        override fun fetchName(): String {
            return "BD"
        }
    },

    JOICY(birthYear = 2016) {
        override fun fetchName(): String {
            return "JD"
        }
    },

    HEILY(birthYear = 2009) {
        override fun fetchName(): String {
            return "HDM"
        }
    };

    abstract fun fetchName(): String
    lateinit var comment: String

    fun calcAge(): Int {
        return Year.now().value - birthYear
    }
}

/**
 *  An enum class has by default properties as : 'name' and 'ordinal'
 */
fun testMyEnumClass() {
    val joicy = MyEnumClass.JOICY
    joicy.name
    joicy.ordinal
    MyEnumClass.entries
}