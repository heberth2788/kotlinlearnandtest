package com.bbs.classtypes

/**
 * Default/standard kotlin class declaration
 */
class ClassType(
    val name: String,
) {

    fun makeCalc(): Int {
        return 1988
    }
}

/**
 * An 'open class' is a class can be inherited.
 * (By default, classes in kotlin cannot be inherited)
 */
open class OpenClassType(val name: String) {

    open var surname: String = ""

    /**
     * This attribute is not open and cannot be overridden
     */
    var greeting: String = "Hi"

    open fun makeCalc(): Int {
        return 1988
    }

    /**
     * This method is not open and cannot be overridden
     */
    fun sayHi() {
        println(greeting)
    }
}

/**
 * A 'data class' implements by default the methods:
 *  1. copy
 *  2. toString
 *  3. equals
 *  4. hashCode
 *  5. component1, components2, etc.
 */
data class DataClassType(
    val name: String,
)

/**
 * It does not have an explicit constructor.
 * Only one instance exist of this object.
 */
object ObjectType {

    const val NAME: String = "HD"

    fun makeCalc(): Int {
        return 1988
    }
}

/**
 * A 'data object' does not have an explicit constructor.
 * A 'data object' implements by default the methods:
 *  1. toString: return the name of the class
 *  2. equals
 *  3. hashCode
 */
data object DataObjectType {

    const val NAME: String = "HD"

    fun makeCalc(): Int {
        return 1988
    }
}

/**
 * Enumeration class
 * It could have abstract methods and attributes
 */
enum class EnumClassType(
    name: String,
) {

    LOADING(name = "L") {

        override val value: Double
            get() = 30.3

        override fun makeCalc(): Int {
            return 1988
        }
    },

    SUCCESS(name = "S") {

        override val value: Double
            get() = 30.3

        override fun makeCalc(): Int {
            return 1988
        }
    },

    ERROR(name = "E") {
        override val value: Double
            get() = 30.3

        override fun makeCalc(): Int {
            return 1988
        }
    };

    abstract fun makeCalc(): Int
    abstract val value: Double
}

/**
 * Sealed class (clase sellada) is used to define a hierarchy of classes
 */
sealed class SealedClassType() {

    class Success(val data: String) : SealedClassType()

    data class Error(val message: String) : SealedClassType()

    object Loading : SealedClassType()

    data object None : SealedClassType()
}

/**
 * An 'inner class' is an internal class that have access to the
 * members of its outer class.
 */
class ClassTypeWithInnerClass(
    val name: String,
) {

    fun fooBar() {
        val obj = InnerClassType(surname = "DEZA")
        println("My name is: ${ obj.fetchFullName() }")
    }

    /**
     * The inner class
     */
    inner class InnerClassType(
        val surname: String,
    ) {

        fun fetchFullName(): String {
            return "$name $surname" // 'name' attribute is from the outer class
        }
    }
}

/**
 * An anonymous type allows to create an object without specify the name
 * of the new class. We need to use the 'object' keyword
 */
class AnonymousClassType() {

    fun fooBar() {

        /**
         * Create an object using an anonymous class (using the 'object' keyword)
         * from an open class type.
         */
        val myObj1 = object : OpenClassType(name = "HD") {
            override fun makeCalc(): Int {
                return 1986
            }
        }

        /**
         * Create an object using an anonymous class (using the 'object' keyword)
         * from an interface type.
         */
        val myObk2 = object : InterfaceType {
            override val myName: String
                get() = "HD"

            override fun makeCalc(): Int {
                return 1985
            }
        }
    }
}

/**
 * To store just one primitive value with a specific characteristics or rules
 * The primary constructor allows only 'one primitive val attribute'
 *
 * It has memory optimizations
 *
 * It needs the @JvmInLine annotation in its declaration
 */
@JvmInline
value class ValueClassType(
    val email: String,
) {

    init {
        if (!email.contains('@')) {
            throw IllegalArgumentException("Invalid email")
        }
    }
}

/**
 * An abstract class is a type of class that can not be instantiated,
 * it is util for inheritance and store some common implementation for
 * its subclasses.
 */
abstract class AbstractClassType(
    val name: String,
) {

    abstract val surname: String

    abstract fun makeCalc(): Int

    /**
     * The subclasses can use this 'common' method without rewrite it
     */
    fun fooBar() {
        println("fooBar")
    }
}

/**
 * Use 'interface' o define a protocol to implement.
 * All of its methods and attributes are 'abstract' by default.
 * It can contain methods with specific implementation.
 */
@AnnotationClassType
interface InterfaceType {

    val myName: String // abstract

    fun makeCalc(): Int // abstract

    fun fooBar() { // not abstract (open by default)
        print("abc")
    }
}

/**
 * To create kotlin annotations
 */
@Target(
    AnnotationTarget.CLASS,
            AnnotationTarget.CONSTRUCTOR,
)
annotation class AnnotationClassType()

