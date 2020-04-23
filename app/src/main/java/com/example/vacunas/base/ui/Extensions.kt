package com.example.vacunas.base.ui

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast


var EditText.content: CharSequence?
    get() = text.toString()
    set(content) {
        setText(content)
    }

fun Context.toast(message: CharSequence, duration: Int) =
    Toast.makeText(this, message, duration).show()

inline fun View.setOnSimpleClickListener(crossinline f: () -> Unit) {
    setOnClickListener { f() }
}