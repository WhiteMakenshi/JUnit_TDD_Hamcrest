package com.makenshi.auth

enum class AuthEvent {
    //Success
    USER_EXIST,
    //fail
    NOT_USER_EXIST,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    ERROR_LENGTH_PASSWORD,

    //Exception
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM,
}