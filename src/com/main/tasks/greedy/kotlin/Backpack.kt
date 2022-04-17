//package com.main.tasks.greedy.kotlin
//
//data class Item(val cost: Double = 0.0, val size: Double = 0.0)
//
//fun main() {
//    val (itemsCount, backpackSize) = readLine()!!.split(" ").map { it.toInt() }
//    with(readItems(itemsCount)) {
//        sortBy { it.size / it.cost }
//        val backpack = fold(Item()) { backpack, item ->
//            if (backpack.size + item.size <= backpackSize) {
//                backpack.copy(cost = backpack.cost + item.cost, size = backpack.size + item.size)
//            } else {
//                val restPlace = backpackSize - backpack.size
//                restPlace > 0
//                if (restPlace > 0) {
//                    val factor = restPlace / item.size
//                    backpack.copy(
//                        cost = backpack.cost + item.cost * factor,
//                        size = backpack.size + restPlace
//                    )
//                } else {
//                    backpack
//                }
//            }
//        }
//        println("%.3f".format(backpack.cost))
//    }
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