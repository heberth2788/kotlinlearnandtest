package com.bbs.operatoroverloading

class ArithmeticOperator {

    data class Point(
        val x: Int,
        val y: Int,
    ) {

        /**
         * a + b
         */
        operator fun plus(other: Point) = Point(
                x = this.x + other.x,
                y = this.y + other.y,
        )

        /**
         * a - b
         */
        operator fun minus(other: Point) = Point(
            x = this.x - other.x,
            y = this.y - other.y,
        )

        /**
         * a * b
         */
        operator fun times(other: Point) = Point(
            x = this.x * other.x,
            y = this.y * other.y,
        )

        /**
         * a * <intValue>
         */
        operator fun times(timesVal: Int) = Point(
            x = this.x * timesVal,
            y = this.y * timesVal,
        )

        /**
         * a / b
         */
        operator fun div(other: Point): Point {
            if (other.x == 0 || other.y == 0) {
                throw IllegalArgumentException("Cannot perform div operation with value zero as denominator")
            }
            return Point(
                x = this.x / other.x,
                y = this.y / other.y,
            )
        }

        /**
         * a % b
         */
        operator fun rem(other: Point): Point {
            if (other.x == 0 || other.y == 0) {
                throw IllegalArgumentException("Cannot perform modulus with zero coordinates")
            }
            return Point(
                x = this.x % other.x,
                y = this.y % other.y,
            )
        }

        /**
         * a()
         */
        operator fun invoke(param1: Int, param2: String) {
            println("invoke: param1 = $param1 and the param2 = $param2")
        }
    }

    fun usePlus() {
        val p1 = Point(x = 3, y = 6)
        println(p1)
        val p2 = Point(x = 1, y = 1)
        println(p2)

        val p3 = p1 + p2
        println("Plus: p1 + p2 = $p3\n")

        var p4 = Point(x = 1, y = 2)
        println(p4)
        p4 += p1
        println("Plus: p4 += p1 = $p4\n")

    }

    fun useMinus() {
        val p1 = Point(x = 3, y = 6)
        println(p1)
        val p2 = Point(x = 1, y = 1)
        println(p2)

        val p3 = p1 - p2
        println("Minus: p1 - p2 = $p3\n")
    }

    fun useRem() {
        val p1 = Point(x = 3, y = 6)
        println(p1)
        val p2 = Point(x = 2, y = 4)
        println(p2)

        val p3 = p1 % p2
        println("Rem: p1 % p2 = $p3\n")
    }

    fun useDiv() {
        val p1 = Point(x = 3, y = 6)
        println(p1)
        val p2 = Point(x = 2, y = 2)
        println(p2)

        val p3 = p1 / p2
        println("Div: p1 / p2 = $p3\n")
    }

    fun useTimes() {
        val p1 = Point(x = 3, y = 6)
        println(p1)
        val p2 = Point(x = 2, y = 2)
        println(p2)

        var p3 = p1 * p2
        println("Times: p1 * p2 = $p3")

        p3 = p1 * 333
        println("Times: p1 * 333 = $p3\n")
    }
}

/**
 * Using extention function
 */
operator fun Char.times(count: Int): String {
    return this.toString().repeat(n = count)
}