package com.main.tasks.dynamic

import com.main.tasks.measure

/*
https://codeforces.com/problemset/problem/527/A
A. Игра с бумагой
*/

fun main() {
    measure { print(findCount(10, 7, 0)) }
}

fun findCount(w: Int, h: Int, count: Int): Int {
    if (w == 0 || h == 0) return count
    return findCount(h, h = w % h, count = count + w / h)
}
