package com.main.tasks.greedy.kotlin

fun main() {
    val (count, len) = readLine()!!.split(" ").map { it.toInt() }
    val codes = mutableMapOf<String, String>()
    repeat(count) {
        val (letter, code) = readLine()!!.split(": ").map { it.trim() }
        codes[code] = letter
    }
    var encodedStr = ""
    readLine()!!.fold("") { encoded, letter ->
        val nextCode = encoded + letter
        if (codes.containsKey(nextCode)) {
            encodedStr += codes[nextCode]; ""
        } else {
            nextCode
        }
    }
    println(encodedStr)
}