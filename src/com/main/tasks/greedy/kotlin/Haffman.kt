package com.main.tasks.greedy.kotlin

import java.util.*

val codes = mutableMapOf<String, String>()
fun main() {
    readLine()?.let { input ->
        val freqMap = mutableMapOf<Char, Int>()
        for (letter in input) freqMap[letter] = freqMap[letter]?.let { it + 1 } ?: 1
        with(PriorityQueue(freqMap.map { Node(letter = it.key, freq = it.value) })) {
            while (size > 1) {
                val l = poll()
                val r = poll()
                Node(left = l.copy(code = 0), right = r.copy(code = 1), freq = l.freq + r.freq).let(::add)
            }
            findCodes(this.poll(), isSingle = freqMap.size > 1)
            val encoded = input.fold("") { c, letter -> c + codes[letter.toString()] }
            println("${freqMap.size} ${encoded.length}")
            freqMap.forEach { println("${it.key}: ${codes[it.key.toString()]}") }
            println(encoded)
        }
    }
}

fun findCodes(node: Node, code: String = "", isSingle: Boolean): String {
    if (node.left == null && node.right == null) {
        val resultCode = code + node.code
        codes[node.letter.toString()] = if (isSingle) resultCode.drop(1) else resultCode
    }
    if (node.left != null) findCodes(node.left, code + node.code, isSingle)
    if (node.right != null) findCodes(node.right, code + node.code, isSingle)
    return code + node.code
}

data class Node(
    val left: Node? = null,
    val right: Node? = null,
    val letter: Char = ' ',
    val code: Int = 0,
    val freq: Int = -1
) : Comparable<Node> {
    override fun compareTo(other: Node): Int = freq - other.freq
}