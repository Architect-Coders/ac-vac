package com.example.vacunas.data.factories

import com.example.vacunas.utils.Constants


class MenuItemFactory {
    companion object {
        fun createMenuItem(id: Int): MenuItemType {
            return when (id) {
                Constants.MenuItemType.STOP_ANTIVACCINE -> MenuItemType.STOP_VACCINE
                Constants.MenuItemType.VACCINE_HISTORY -> MenuItemType.VACCINE_HISTORY
                Constants.MenuItemType.VACCINE_INFO -> MenuItemType.VACCINE_INFO
                Constants.MenuItemType.VACCINE_CALENDAR -> MenuItemType.VACCINE_CALENDAR
                else -> MenuItemType.UNKNOWN
            }
        }
    }

    enum class MenuItemType {
        UNKNOWN,
        STOP_VACCINE,
        VACCINE_INFO,
        VACCINE_HISTORY,
        VACCINE_CALENDAR;

        fun onClick(listener: OnMenuItemSelected) {
            listener.onMenuItemSelected(this)
        }
    }

    interface OnMenuItemSelected {
        fun onMenuItemSelected(menuItemType: MenuItemType)
    }
}