package com.example.vacunas.base.ui

import android.app.Activity
import android.view.View
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


var View.visible: Boolean
    get() = this.visibility != View.GONE
    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
    }

var EditText.content: CharSequence?
    get() = text.toString()
    set(content) {
        setText(content)
    }