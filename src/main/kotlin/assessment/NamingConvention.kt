package com.bbs.assessment

const val THIS_IS_MY_VAL_1: Int = 2024

class NamingConvention {

    // Camel case:
    val thisIsMyValCamelCase: Int = 1988

    // Pascal case:
    val ThisIsMyValPascalCase: Int = 1987

    // Snake case:
    val this_is_my_val_snake_case: Int = 2016

    // Screaming Snake case: In Kotlin use it for constants (const).
    val THIS_IS_MY_VAL_SCREAMING_SNAKE_CASE: Int = 2009

    // Kebab case: Kotlin doesn't allow it
    //val this-is-my-val: Int = 2009
    //val THIS-IS-MY-VAL: Int = 2009

    companion object {

        const val THIS_IS_MY_VAL_2: Int = 2024
    }
}