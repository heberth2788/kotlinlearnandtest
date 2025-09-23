package com.bbs.assessment

object InterviewQuestions {

    /**
     * Anagram detection
     *
     * E.g:
     *      input: str1 = "anagram", str2 = "magrana"  , output: true
     *      input: str1 = "car", str2 = "tac"          , output: false
     */
    fun isAnagramV1(str1: String, str2: String): Boolean {

        if (str1.length != str2.length) return false

        return str1.toCharArray().sorted() == str2.toCharArray().sorted()
    }

    fun isAnagramV2(str1: String, str2: String): Boolean {

        if (str1.length != str2.length) return false

        val str1Map: MutableMap<Char, Int> = mutableMapOf()
        val str2Map: MutableMap<Char, Int> = mutableMapOf()

        str1.forEach { char ->
            str1Map[char] = str1Map.getOrDefault(char, 0) + 1
        }
        str2.forEach { char ->
            str2Map[char] = str2Map.getOrDefault(char, 0) + 1
        }

        str1Map.forEach { (key, value) ->
            if (str2Map[key] != value) return false
        }

        return true
    }

    /**
     * Most repeated character, if more than one, return the first one
     * in alphabetical order.
     *
     * E.g:
     *      input: "android"     , output: 'd'
     *      input: "ddaanrooi"   , output: 'a'
     */
    fun getMostRepeatedChar(str: String): Char {

        val charMap: MutableMap<Char, Int> = mutableMapOf()

        str.toCharArray()
            .sorted()
            .forEach { char ->
            charMap[char] = charMap.getOrDefault(char, 0) + 1
        }

        return (charMap.maxBy { it.value }).key
    }

    /**
     * Reverse vowels.
     *
     * E.g:
     *      input: "hello"      , output: "holle"
     *      input: "androIde"   , output: "endrIoda"
     *      input: "androId"   , output: "Indroad"
     */
    fun reserverOnlyVowelsV1(str: String): String {

        if (str.isEmpty()) return ""

        val vowels = "aeiouAEIOU"
        val strArray = str.toCharArray()
        var start = 0
        var end = str.length - 1

        while (start < end) {
            if (vowels.contains(strArray[start]) && vowels.contains(strArray[end])) {
                val temp = strArray[start]
                strArray[start] = strArray[end]
                strArray[end] = temp
                start++
                end--
            } else {
                if (!vowels.contains(strArray[start])) start++
                if (!vowels.contains(strArray[end])) end--
            }
        }
        return strArray.joinToString("")
    }

    fun reserverOnlyVowelsV2(str: String): String {

        val vowelsString = "aeiouAEIOU"
        var vowelsInStr: String = str.filter { it in vowelsString }
        vowelsInStr = vowelsInStr.reversed()

        val result = StringBuilder()
        var pivotInt = 0

        str.forEach { char ->
            if (char in vowelsString ) {
                result.append(vowelsInStr[pivotInt++])
                return@forEach
            }
            result.append(char)
        }

        return result.toString()
    }

    /**
     * Reorder numbers of a list to beginning for even numbers and end for odd numbers
     *
     * E.g:
     *      input: [4,5,6,1,2,3]    , output: [4,6,2,5,1,3]
     *                              , output: [2,4,6,1,3,5] (in order)
     */
    fun evenNumbersThenOddNumbersV1(numbers: List<Int>): List<Int> {

        if (numbers.isEmpty()) return emptyList()

        val evenNumbers: MutableList<Int>  = mutableListOf()
        val oddNumbers: MutableList<Int>  = mutableListOf()

        numbers.forEach { num ->
            if (num % 2 == 0) evenNumbers.add(num) else oddNumbers.add(num)
//            if (num.mod(2) == 0) evenNumbers.add(num) else oddNumbers.add(num)
        }

//        return evenNumbers + oddNumbers
        return evenNumbers.sorted() + oddNumbers.sorted()
    }

    fun evenNumbersThenOddNumbersV2(numbers: List<Int>): List<Int> {
        if (numbers.isEmpty()) return emptyList()

        val mutListAux: MutableList<Int> = numbers.toMutableList()
        var lastOddIndex: Int = -1
        var pivotValue: Int = 0

        mutListAux.forEachIndexed { index, value ->

            if (value.isEven() && lastOddIndex != -1) {
                pivotValue = mutListAux[lastOddIndex]
                mutListAux[lastOddIndex] = value
                mutListAux[index] = pivotValue

                lastOddIndex++
                return@forEachIndexed
            }
            else if (value.isEven().not() && lastOddIndex == -1) {
                lastOddIndex = index
            }
        }
        return mutListAux.toList()
    }

    fun Int.isEven(): Boolean = (this.mod(2) == 0)

    /**
     * Fibonacci algorithms comparison
     */
    // 1. Iteration
    // 2. Recursivity
    // 3. Recursivity with memoization
}