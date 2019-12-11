package com.example.vacunas.ui.user

import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.ui.blank.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment<UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModel()

    //region Override BaseFragment methods
    override fun getLayoutId(): Int = R.layout.fragment_list_users

    override fun setObservers() {}

    override fun setupView() {}
    //endregion
}
