package com.example.vacunas.utils

import com.example.vacunas.R

class Constants {
    object Screens {
        const val SPLASH_FRAGMENT = "SPLASH_FRAGMENT"
        const val USER_LIST_FRAGMENT = "USER_LIST_FRAGMENT"
        const val BLANK_FRAGMENT = "BLANK_FRAGMENT"
    }

    object NavActions {
        const val SPLASH_TO_USERLIST = R.id.action_splashFragment_to_userListFragment
        const val USERLIST_TO_BLANK = R.id.action_userListFragment_to_blankFragment
        const val USERLIST_TO_USEREDITING = R.id.action_userListFragment_to_userEditingFragment
        const val USERLIST_TO_DETAIL = R.id.action_userListFragment_to_detailFragment
    }

    object MenuItemType {
        const val STOP_ANTIVACCINE = R.id.menu_stop_antivaccine
        const val VACCINE_CALENDAR = R.id.menu_vaccine_calendar
        const val VACCINE_INFO = R.id.menu_vaccine_info
        const val VACCINE_HISTORY = R.id.menu_vaccine_history
    }
}
