package com.makenshi.auth

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.both
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.endsWith
import org.hamcrest.Matchers.everyItem
import org.hamcrest.Matchers.hasItemInArray
import org.hamcrest.Matchers.not
import org.junit.Test

class AuthHamcrestTest {
    //given-when-then
    @Test
    fun loginUser_correctData_returnsSuccessEvent() {

        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.co", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent() {
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("antgmail.com", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "aaa123")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_invalidData_returnsFailEvent() {
        val result = userAuthenticationTDD("antgmail.co", "1234aa")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val result = userAuthenticationTDD(null, "1234")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_nullPassword_returnsException() {
        try {
            val result = userAuthenticationTDD("ant@gmail.com", null)
            assertThat(AuthEvent.NULL_PASSWORD, `is`(result))
        } catch (ex: Exception) {
            (ex as? AuthException)?.let {
                assertThat(AuthEvent.NULL_PASSWORD, `is`(it.AuthEvent))
            }
        }
    }

    @Test
    fun loginUser_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch (ex : Exception) {
            (ex as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.AuthEvent))
            }
        }
    }

    @Test
    fun loginUser_wrongLengthPassword_returnsException() {
        val result = userAuthenticationTDD("ant@gmail.com", "124")
        assertThat(AuthEvent.ERROR_LENGTH_PASSWORD, `is`(result))
    }

    @Test
    fun checkNames_differentUsers_match() {
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_noMatch() {
        val email = "ant@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnsString() {
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursos.com"
        val emails = arrayOf(oldEmail, newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString() {
        val nextEmail = "alain@cursos.com"
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursos.com"
        val emails = arrayListOf(oldEmail, newEmail, nextEmail)
        val newEmails = arrayListOf(newEmail, nextEmail)
        assertThat(newEmails, everyItem(endsWith("cursos.com")))

    }
}