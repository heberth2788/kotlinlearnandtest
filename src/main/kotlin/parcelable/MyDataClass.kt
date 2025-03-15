package com.bbs.parcelable

data class MyDataClass(
    val dni: String,
    val name: String,
    val surname: String,
    val bornYear: Int,
)

// data class methods: equals, copy, toString, hashCode and componentN
fun testMyDataClass() {
    val myObject = MyDataClass(dni = "45453948", name = "HD", surname = "Deza", bornYear = 1988)

    // copy
    val myCopy: MyDataClass  = myObject.copy(name = "Heberth Deza")

    // equals
    var areEquals: Boolean = false
    areEquals = myObject.equals(myCopy)
    areEquals = myObject == myCopy

    // toString
    val myObjStr: String = myObject.toString()

    // hashCode
    val myHashCode: Int = myObject.hashCode()

    // componentN
    var pivot: String = myObject.component1() // dni
    pivot = myObject.component2() // name
    pivot = myObject.component3() // surname
    val bornYear: Int = myObject.component4() // bornYear
}