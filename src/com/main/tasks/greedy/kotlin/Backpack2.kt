package com.main.tasks.greedy.kotlin

data class Item(val cost: Double, val size: Double)

fun main() {
    val (itemsCount, backpackSize) = readLine()!!.split(" ").map { it.toInt() }
    with(readItems(itemsCount)) {
        var backpack = 0.0
        var cost = 0.0
        var done = false
        forEach { item ->
            if (done) return@forEach
            if (backpack + item.size <= backpackSize) {
                backpack += item.size
                cost += item.cost
            } else {
                val restPlace = backpackSize - backpack
                if (restPlace > 0) {
                    val factor = restPlace / item.size
                    cost += item.cost * factor
                }
                done = true
            }
        }
        println("%.3f".format(cost))
    }
}

fun readItems(lines: Int): MutableList<Item> {
    return mutableListOf<Item>().apply {
        repeat(lines) {
            val (a, b) = readLine()!!.split(" ").map { value -> value.toDouble() }
            if (a > 0.0) {
                add(Item(cost = a, size = b))
            }
        }
    }
}