package com.main.tasks.greedy.kotlin

import java.util.*

/*
Задача на программирование: различные слагаемые
По данному числу n найдите максимальное число kk, для которого nn можно представить как сумму kk различных натуральных слагаемых. Выведите в первой строке число kk, во второй — kk слагаемых.
*/
fun main() {
    val x = readln().toInt()
    val numbers = Stack<Int>()
    var currentTerm = 1
    var sum = 0
    while (sum < x) {
        if (sum + currentTerm > x) { // last step
            val delta = x - sum
            numbers[numbers.size - 1] += delta
            break
        } else {                       // regular step
            sum += currentTerm
            numbers.add(currentTerm++)
        }
    }
    println(numbers.size)
    print(numbers.joinToString(" "))
}