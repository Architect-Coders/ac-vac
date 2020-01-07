package com.example.vacunas.ui.user.editing

import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserEditingFragment : BaseFragment<UserEditingViewModel>() {

    override val viewModel: UserEditingViewModel by viewModel()

    //region Lifecycle methods
    override fun getLayoutId(): Int = R.layout.fragment_edit_user


    //endregion
}