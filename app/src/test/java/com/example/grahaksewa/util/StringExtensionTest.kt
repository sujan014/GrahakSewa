package com.example.grahaksewa.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StringExtensionTest {
    @Test
    fun `test string contains no number returns false when check for it`(){
        val result = "NoNumber".containsOnlyNumber()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains number and other characters returns false when check for it`(){
        val result = "Number1234".containsOnlyNumber()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains special number and special characters returns false when check for it`(){
        val result = "1234^&*%".containsOnlyNumber()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains 1 digit returns true when check for it`(){
        val result = "1".containsOnlyNumber()
        assertThat(result).isTrue()
    }

    @Test
    fun `test string contains multiple digit returns true when check for it`(){
        val result = "12".containsOnlyNumber()
        assertThat(result).isTrue()
    }
}