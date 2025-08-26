package com.makenshi.auth

class AuthException(val AuthEvent : AuthEvent, msg: String? = null) : Exception(msg) {
}