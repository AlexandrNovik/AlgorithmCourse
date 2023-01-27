package com.main.tasks.greedy.kotlin

import java.util.*

data class Line(val start: Int, val end: Int)

fun main() {
    with(readLines()) {
        sortBy { it.end }
        val points = fold(Stack<Int>()) { pointsStack, line ->
            pointsStack.apply {
                if (isEmpty() || line.start > peek()) push(line.end)
            }
        }
        println(points.size)
        println(points.joinToString(" "))
    }
}

fun readLines(): MutableList<Line> {
    return mutableListOf<Line>().apply {
        readlnOrNull()?.toInt()?.let {
            repeat(it) {
                val (a, b) = readln().split(" ").map { value -> value.toInt() }
                add(Line(start = a, end = b))
            }
        }
    }
}