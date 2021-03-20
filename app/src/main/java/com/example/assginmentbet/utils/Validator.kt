package com.example.assginmentbet.utils

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class Validator {

    companion object {

        // Default validation messages
        private val PASSWORD_POLICY = """Password should be minimum 8 characters long,
            |should contain at least one capital letter,
            |at least one small letter""".trimMargin()

        private val NAME_VALIDATION_MSG = "Enter a valid name"

        /**
         * Retrieve string data from the parameter.
         * @param data - can be EditText or String
         * @return - String extracted from EditText or data if its data type is Strin.
         */
        private fun getText(data: Any): String {
            var str = ""
            if (data is EditText) {
                str = data.text.toString()
            } else if (data is String) {
                str = data
            }
            return str
        }
    }

    /**
     * Checks if the name is valid.
     * @param data - can be EditText or String
     * @param updateUI - if true and if data is EditText, the function sets error to the EditText or its TextInputLayout
     * @return - true if the name is valid.
     */
    fun isValidName(data: Any, updateUI: Boolean = true): Boolean {
        val str = getText(data)
        val valid = str.trim().length > 2
        return valid
    }

    /**
     * Checks if the password is valid as per the following password policy.
     * Password should be minimum minimum 8 characters long.
     * Password should contain at least one capital letter.
     * Password should contain at least one small letter.

     * @param data - can be EditText or String
     * @param updateUI - if true and if data is EditText, the function sets error to the EditText or its TextInputLayout
     * @return - true if the password is valid as per the password policy.
     */
    fun isValidPassword(data: Any, updateUI: Boolean = true): Boolean {
        val str = getText(data)
        var valid = true

        // Password policy check
        // Password should be minimum minimum 8 characters long
        if (str.length < 8) {
            valid = false
        }

        // Password should contain at least one capital letter
        var exp = ".*[A-Z].*"
        var pattern = Pattern.compile(exp)
        var matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        // Password should contain at least one small letter
        exp = ".*[a-z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        return valid
    }

}