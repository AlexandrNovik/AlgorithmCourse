package com.main.tasks.gcd_lcm

import com.main.tasks.measure
import java.io.File

fun main() {
    val (a, b) = File("numbers.txt").readLines().map { it.toInt() }
    measure { print(findGcd(a, b)) }
}

fun findGcd(a: Int, b: Int): Int {
    if (a == 0) return b
    if (b == 0) return a
    return findGcd(b, a % b)
}