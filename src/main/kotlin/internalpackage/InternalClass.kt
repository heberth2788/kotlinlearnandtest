package com.bbs.internalpackage

internal open class InternalClass {

    var propertyA: String = "" // "public" by default
    private var propertyB: Int = 0
    protected var propertyC: Double = 0.0
    internal var propertyD: Boolean = true

    fun methodA() {} // "public by default"
    private fun methodB(){}
    protected fun methodC(){}
    internal fun methodD(){}

}