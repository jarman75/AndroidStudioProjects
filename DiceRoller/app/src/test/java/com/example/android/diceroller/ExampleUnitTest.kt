package com.example.android.diceroller

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun use_VarVal() {
        var a = 5 //mutable
        assertEquals(5, a)

        val c = 15 //readonly
        assertEquals(15, c)

        var b = 1
        val s1 = "b is $b"

        assertEquals("b is 1", s1)
    }

    @Test
    fun test_get_length_isCorrect() {
        val strValue = "test string"
        var result = getStringLength(strValue)
        assertEquals(11, result)
    }

    @Test
    fun test_get_length_isNull() {
        val value = 125
        var result = getStringLength(value)
        assertEquals(null, result)
    }

    @Test
    fun test_describe_isCorrect() {
        assertEquals("One",describe(1))

        assertEquals("Greeting", describe("Hello"))

        val value: Long = 1000
        assertEquals("Long", describe(value))

        val a: Int = 10
        assertEquals("Not a string", describe(a))

        val str: String = "nobody"
        assertEquals("Unknown", describe(str))
    }

    @Test
    fun test_PersonClass(){
        var paco = Person("paco", "Perez")
        assertEquals("PACO, Perez", paco.name)
    }

    private fun getStringLength(obj: Any) : Int? {
        if (obj is String) return obj.length
        return null
    }

    private fun describe(obj: Any): String =
        when (obj) {
            1           -> "One"
            "Hello"     -> "Greeting"
            is Long     -> "Long"
            !is String  -> "Not a string"
            else        -> "Unknown"
        }

    class Person constructor(firstName: String, name: String) {
        var name = "${firstName.toUpperCase()}, $name"
    }
}


