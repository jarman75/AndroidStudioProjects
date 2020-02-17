package com.example.android.diceroller

import org.junit.Test

import org.junit.Assert.*

class TestExample {

    @Test
    fun testFixed() {
        assertEquals("", toCamelCase(""))
        assertEquals("theStealthWarrior", toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", toCamelCase("A-B-C"))
    }

    private fun toCamelCase(str: String) =
        str.split('-', '_').mapIndexed {index, word -> if (index != 0) word.capitalize() else word}.joinToString("")




    private fun toCamelCase_first(str: String): String {

        var output = ""
        var head = false
        for (c in str) {
            if (c=='_' || c=='-')
                head = true
            else {
                if (head) {
                    output += c.toUpperCase()
                    head = false
                }else
                    output += c
            }
        }
        return output
    }
}