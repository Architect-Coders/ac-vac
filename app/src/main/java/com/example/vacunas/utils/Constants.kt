package com.example.vacunas.utils

import com.example.vacunas.R

class Constants {
    object Screens {
        const val SPLASH_FRAGMENT = "SPLASH_FRAGMENT"
        const val USER_LIST_FRAGMENT = "USER_LIST_FRAGMENT"
        const val BLANK_FRAGMENT = "BLANK_FRAGMENT"
    }

    object NavActions {
        const val splash_to_userList = R.id.action_splashFragment_to_userListFragment
        const val userList_to_blank = R.id.action_userListFragment_to_blankFragment
    }
}
