package com.example.android.codewarskatas

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestPersistence {
    @Test
    fun `Basic Tests`() {
        assertEquals(3, persistence(39))
        assertEquals(0, persistence(4))
        assertEquals(2, persistence(25))
        assertEquals(4, persistence(999))
    }

    private fun persistence(num: Int): Int {

        var i:Int=0
        var n:Int=0

        i += 1

        if(num<10) return i

        val numbers = num.toString().map { c -> c.toString().toInt() }

        for (number in numbers) {
            n = number
            persistence(number)
        }

        return i
    }
}
