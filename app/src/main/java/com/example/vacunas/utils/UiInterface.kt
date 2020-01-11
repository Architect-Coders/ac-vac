package com.example.vacunas.utils

interface UiInterface {
    interface MainActivityContract {
        fun toggleBottomAppBar(visible: Boolean)
        fun toggleFabButton(visible: Boolean)
    }
}