package com.bbs.coroutine

import kotlinx.coroutines.*

class MyCoroutineTest {

    /**
     * Use "runBlocking {...} = T"
     * only in the main or test functions.
     */
    fun myRunBlocking() {

        val task1 = runBlocking {
            println("\ttask1 start: ${ Thread.currentThread().name }")
            delay(2000)
            println("\ttask1 end: ${ Thread.currentThread().name }")
        }

        val task2 = runBlocking {
            println("\ttask2 start: ${ Thread.currentThread().name }")
            delay(2000)
            println("\ttask2 end: ${ Thread.currentThread().name }")
        }
    }

    /**
     * Use "launch {...} = Job"
     * For non result return value.
     * A Job is able to:
     *      cancel() : cancel the job
     *      join() : wait for completion
     */
    suspend fun myLaunch() = coroutineScope {

        println("myLaunch start: ${ Thread.currentThread().name }")

        val myJob = launch {
            println("\tmyJob start: ${ Thread.currentThread().name }")

            val task1 = runBlocking {
                println("\t\ttask1 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask1 end: ${ Thread.currentThread().name }")
            }

            val task2 = runBlocking {
                println("\t\ttask2 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask2 end: ${ Thread.currentThread().name }")
            }

            println("\tmyJob end: ${ Thread.currentThread().name }")
        }
        println("myJob.join()")
        myJob.join() // To wait for the job finish
        println("myLaunch end: ${ Thread.currentThread().name }")
    }

    suspend fun myLaunchV2() = coroutineScope {

        println("myLaunch start: ${ Thread.currentThread().name }")

        val myJob = launch {
            println("\tmyJob start: ${ Thread.currentThread().name }")

            val task1 = launch {
                println("\t\ttask1 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask1 end: ${ Thread.currentThread().name }")
            }

            val task2 = launch {
                println("\t\ttask2 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask2 end: ${ Thread.currentThread().name }")
            }

            println("\tmyJob end: ${ Thread.currentThread().name }")
        }
        println("myJob.join()")
        myJob.join() // To wait for the job finish
        println("myLaunch end: ${ Thread.currentThread().name }")
    }

    suspend fun myLaunchV3() = coroutineScope {

        println("myLaunch start: ${ Thread.currentThread().name }")

        val myJob = launch {
            println("\tmyJob start: ${ Thread.currentThread().name }")

            val task1 = launch {
                println("\t\ttask1 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask1 end: ${ Thread.currentThread().name }")
            }

            val task2 = launch {
                println("\t\ttask2 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask2 end: ${ Thread.currentThread().name }")
            }

            task1.join() // To wait for the job finish
            task2.join() // To wait for the job finish

            val task3 = launch {
                println("\t\ttask3 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask3 end: ${ Thread.currentThread().name }")
            }

            println("\tmyJob end: ${ Thread.currentThread().name }")
        }
        println("myJob.join()")
        myJob.join() // To wait for the job finish
        println("myLaunch end: ${ Thread.currentThread().name }")
    }

    /**
     * Use "async {...} = Deferred<T>"
     * For return value
     * A Deferred<T> is able to:
     *      await() : wait for completion
     */
    suspend fun myAsync() = coroutineScope {
        println("myAsync start: ${ Thread.currentThread().name }")

        val myJob = launch {
            println("\tmyJob start: ${ Thread.currentThread().name }")

            val task1 = launch {
                println("\t\ttask1 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask1 end: ${ Thread.currentThread().name }")
            }

            val task2: Deferred<String> = async {
                println("\t\ttask2 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask2 end: ${ Thread.currentThread().name }")

                "Deferred String"
            }

            task1.join() // To wait for the job finish

            val task3 = launch {
                println("\t\ttask3 start: ${ Thread.currentThread().name }")
                delay(2000)
                println("\t\ttask3 end: ${ Thread.currentThread().name }")
            }

            task2.await() // To wait for the job finish

            println("\tmyJob end: ${ Thread.currentThread().name }")
        }
        println("myJob.join()")
        myJob.join() // To wait for the job finish
        println("myAsync end: ${ Thread.currentThread().name }")
    }
}