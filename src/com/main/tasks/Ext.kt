package com.main.tasks

fun measure(lambda: () -> Unit) {
    val start = System.currentTimeMillis()
    lambda.invoke()
    println()
    val end = System.currentTimeMillis()
    println("Done in: ${end - start}ms")
}