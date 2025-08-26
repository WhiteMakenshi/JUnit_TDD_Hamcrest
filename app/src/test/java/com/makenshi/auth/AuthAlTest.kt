package com.makenshi.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthAlTest {
    private var email: String? = null
    private var password: String? = null

    @Before
    fun setup() {
        email = "ant@gmail.com"
        password = "1234"
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.NOT_USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticated)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.EMPTY_FORM, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException() {
        val isAuthenticated = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.NULL_EMAIL, isAuthenticated)
    }

    @Test
    fun login_nullPassword_returnsException() {
        assertThrows(AuthException::class.java) {
            userAuthenticationTDD(email, password)
        }
    }

    @Test
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            assertEquals(AuthEvent.NULL_FORM, result)
        } catch (ex : Exception) {
            (ex as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.AuthEvent)
            }
        }
    }

    @Test
    fun login_errorLengthPassword_returnsException() {
        val result = userAuthenticationTDD(email, password)
        assertEquals(AuthEvent.ERROR_LENGTH_PASSWORD, result)
    }
}