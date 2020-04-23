package com.example.vacunas.utils

interface UiInterface {
    interface MainActivityContract {
        fun toggleBottomAppBarVisibility(visible: Boolean)
        fun toggleFabButtonVisibility(visible: Boolean)
    }
}