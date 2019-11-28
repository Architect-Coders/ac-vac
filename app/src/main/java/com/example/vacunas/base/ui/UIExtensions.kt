package com.example.vacunas.base.ui

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun <V : View> Activity.bindView(@IdRes idRes: Int): Lazy<V> {
    return lazy(LazyThreadSafetyMode.NONE) {
        findViewById<V>(idRes)
    }
}

fun <V : View> Fragment.bindView(@IdRes idRes: Int): Lazy<V> {
    return lazy(LazyThreadSafetyMode.NONE) {
        view!!.findViewById<V>(idRes)
    }
}

fun <V : View> RecyclerView.ViewHolder.bindView(@IdRes idRes: Int): Lazy<V> {
    return lazy(LazyThreadSafetyMode.NONE) {
        itemView.findViewById<V>(idRes)
    }
}

fun AppCompatActivity.replaceFragment(fragmentId: Int, addBackStack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction()
//    transaction.replace(fragmentId)
//    transaction.addToBackStack()
//    transaction.commit();
}

var View.visible: Boolean
    get() = this.visibility != View.GONE
    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
    }