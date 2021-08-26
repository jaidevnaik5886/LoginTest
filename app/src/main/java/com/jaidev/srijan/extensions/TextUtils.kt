package com.jaidev.srijan.extensions

import java.util.regex.Matcher
import java.util.regex.Pattern

fun String?.isValidUsername(): Boolean {
    var ch: Char
    var capitalFlag = false
    var lowerCaseFlag = false
    var numberFlag = false
    for (element in this!!) {
        ch = element
        if (Character.isDigit(ch)) {
            numberFlag = true
        } else if (Character.isUpperCase(ch)) {
            capitalFlag = true
        } else if (Character.isLowerCase(ch)) {
            lowerCaseFlag = true
        }
        if (numberFlag && capitalFlag && lowerCaseFlag) return true
    }
    return false
}


fun String?.isValidPassword(): Boolean {
    val regex = ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{0,5}\$")
    val p: Pattern = Pattern.compile(regex)
    if (this == null) {
        return false
    }
    val m: Matcher = p.matcher(this)
    return m.matches()
}
