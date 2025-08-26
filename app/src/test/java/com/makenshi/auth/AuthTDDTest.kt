package com.makenshi.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore
import org.junit.Test

class AuthTDDTest {

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.co", "1234")
        assertEquals(AuthEvent.NOT_USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticated)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antgmail.com", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "aaa123")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD("antgmail.co", "1234aa")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException() {
        val isAuthenticated = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAuthenticated)
    }

    @Test
    fun login_nullPassword_returnsException() {
        assertThrows(AuthException::class.java) {
            userAuthenticationTDD("ant@gmail.com", null)
        }
    }

    @Test
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertEquals(AuthEvent.NULL_FORM, result)
        } catch (ex : Exception) {
            (ex as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.AuthEvent)
            }
        }
    }

    @Ignore("Falta definir la longitud de la contraseña")
    @Test
    fun login_errorLengthPassword_returnsException() {
        val result = userAuthenticationTDD("ant@gmail.com", "124")
        assertEquals(AuthEvent.ERROR_LENGTH_PASSWORD, result)
    }
}