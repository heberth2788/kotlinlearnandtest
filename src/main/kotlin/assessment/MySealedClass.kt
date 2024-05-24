package com.bbs.assessment

/**
 * A sealed class is used to define a class
 * hierarchy (A parent with children)
 *
 * A sealed class is defined only in one
 * file (A parent with children), it means
 * that we can not expand the number of children
 * (That's why is 'sealed')
 */
sealed class MySealedClass(val birthYear: Int)
class Heberth(val name: String): MySealedClass(birthYear = 1988)
class Lilian(val name: String, val birthY: Int): MySealedClass(birthYear = birthY)
object Joicy: MySealedClass(2016) // Similar to values of an Enum class
object Heily: MySealedClass(20090) // Similar to values of an Enum class