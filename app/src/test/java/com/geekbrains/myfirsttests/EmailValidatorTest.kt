package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.StringBuilder

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_WithoutDomain_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("name"))
    }

    @Test
    fun emailValidator_TooLongEmail_ReturnsFalse(){
        var stringBuilder = StringBuilder()
        for(i in 1..257){
            stringBuilder = stringBuilder.append("a")
        }
        stringBuilder.append("@mail.ru")
        assertFalse(EmailValidator.isValidEmail(stringBuilder.toString()))
    }

    @Test
    fun emailValidator_TooLongDomain_ReturnsFalse(){
        var stringBuilder = StringBuilder("name@")
        for(i in 1..66){
            stringBuilder = stringBuilder.append("a")
        }
        stringBuilder.append(".ru")
        assertFalse(EmailValidator.isValidEmail(stringBuilder.toString()))
    }

    @Test
    fun emailValidator_TooLongDomainExpansion_ReturnsFalse(){
        var stringBuilder = StringBuilder("name@mail.")
        for(i in 1..27){
            stringBuilder = stringBuilder.append("a")
        }
        assertFalse(EmailValidator.isValidEmail(stringBuilder.toString()))
    }
}
