package com.main.tasks.greedy.kotlin

fun main() {
    val (count, len) = readln().split(" ").map { it.toInt() }
    val codes = mutableMapOf<String, String>()
    repeat(count) {
        val (letter, code) = readln().split(": ").map { it.trim() }
        codes[code] = letter
    }
    var encodedStr = ""
    readln().fold("") { encoded, letter ->
        val nextCode = encoded + letter
        if (codes.containsKey(nextCode)) {
            encodedStr += codes[nextCode]; ""
        } else {
            nextCode
        }
    }
    println(encodedStr)
}