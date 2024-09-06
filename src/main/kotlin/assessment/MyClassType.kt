package com.bbs.assessment

class MyClassType {

    class MyClassTypeA(
        val name: String, // get
        val description: String, // get
        private val value: Int,
    )

    class MyClassTypeB(
        var name: String, // get, set
        var description: String, // get, set
        private var value: Int,
    )

    class MyClassTypeC(
        name: String, // It is not an attribute, but a parameter
        description: String, // It is not an attribute, but a parameter
        value: Int, // It is not an attribute, but a parameter
        val newValue: Int = value * 2, // get
    ) {
        private val fullNameAndDescA: String by lazy { name + description }
        private val fullNameAndDescB: String =  name + description
    }

    fun testing() {

        val myClassTypeA = MyClassTypeA(name = "HD", description = "A cool man", value = 10)
        // myClassTypeA.description = "A bad man" // Error: set
        val descA = myClassTypeA.description // Good: get

        val myClassTypeB = MyClassTypeB(name = "HD", description = "A cool man", value = 10)
        myClassTypeB.description = "A bad man" // Good: set
        val descB = myClassTypeB.description // Good: get

        val myClassTypeC = MyClassTypeC(name = "HD", description = "A cool man", value = 10)
        // myClassTypeC.description = "A bad man" // Error: set
        // myClassTypeC.description // Error: get
        myClassTypeC.newValue // Good: get
    }
}