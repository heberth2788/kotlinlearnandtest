package com.bbs.tdd

import com.bbs.assessment.Calculator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun `test add`() {
        val myCalc = Calculator()
        val res: Int = myCalc.parse("5 add 3")

        assertEquals(8, res)
    }

    @Test
    fun `test sub`() {
        val myCalc = Calculator()
        val res: Int = myCalc.parse("5 sub 3")

        assertEquals(2, res)
    }
}