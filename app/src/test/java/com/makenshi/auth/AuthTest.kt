package com.makenshi.auth

import org.junit.Assert.assertFalse
import org.junit.Test

class AuthTest {
    @Test
    //Accion a ejecutar - Escenario - Resultado esperado
    fun login_complete_returnsTrue() {
        val authenticate = userAuthentication("ant@gmail.com", "1234")
        assert(authenticate)
    }

    @Test
    fun login_complete_returnsFalse() {
        val authenticate = userAuthentication("ant@gmail.co", "1234")
        assertFalse(authenticate)
    }

    @Test
    fun login_emptyEmail_returnsFalse() {
        val authenticate = userAuthentication("", "1234")
        assertFalse(authenticate)
    }

// TDD
//    @Test
//    fun login_nullEmail_returnsFalse() {
//        val authenticate = userAuthenticationTDD(null, "1234")
//        assertEquals(AuthEvent.NOT_USER_EXIST, authenticate)
//    }
//
//    @Test
//    fun login_nullPassword_returnsFalse() {
//        val authenticate = userAuthenticationTDD("ant@gmail.com", null)
//        assertFalse(authenticate)
//    }
}