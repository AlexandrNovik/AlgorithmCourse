package com.main.tasks.greedy.kotlin

//data class Item(val cost: Double, val size: Double)
//
//fun main() {
//    val (itemsCount, backpackSize) = readLine()!!.split(" ").map { it.toInt() }
//    list = readItems(itemsCount)
//    var backpack = 0.0
//    var cost = 0.0
//    var done = false
//    list.forEach { item ->
//        if (done) return@forEach
//        if (backpack + item.weight <= backpackSize) {
//            backpack += item.weight
//            cost += item.cost
//        } else {
//            val restPlace = backpackSize - backpack
//            if (restPlace > 0) {
//                val factor = restPlace / item.weight
//                cost += item.cost * factor
//            }
//            done = true
//        }
//    }
//    println("%.3f".format(cost))
//}
//
//fun readItems(lines: Int): MutableList<Item> {
//    return mutableListOf<Item>().apply {
//        repeat(lines) {
//            val (a, b) = readLine()!!.split(" ").map { value -> value.toDouble() }
//            if (a > 0.0) {
//                add(Item(cost = a, size = b))
//            }
//        }
//    }
//}