package com.main.tasks.gaphs

import java.util.*

fun main(args: Array<String>) {
    SearchWide().find()
}

class SearchWide {
    private val olya = Contact("Olya", listOf(Contact("Olya1"), Contact("Olya2"), Contact("Olya3")))
    private val masha = Contact("Masha", listOf(Contact("Masha1"), Contact("Masha2"), Contact("Masha3"), olya))
    private val vova = Contact("Vova", listOf(masha, olya, Contact("Vova1"), Contact("Vova2"), Contact("Vova3")))

    private val graph = Contact("me", listOf(olya, masha, vova))
    private val checked = hashSetOf<Contact>()

    fun find() {
        val deque: Queue<Contact> = LinkedList(graph.contacts)
        while (deque.isNotEmpty()) {
            val contact = deque.poll()
            if (checked.contains(contact)) continue
            println("Checking: name: ${contact.name}")
            if (contact.find) {
                println("Found: name: ${contact.name}")
                return
            } else {
                checked.add(contact)
                contact.contacts.forEach { groupContact -> deque.add(groupContact) }
            }
        }
    }
}

data class Contact(val name: String, val contacts: List<Contact> = emptyList(), val find: Boolean = false)
