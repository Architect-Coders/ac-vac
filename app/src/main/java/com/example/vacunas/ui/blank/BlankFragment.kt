package com.example.vacunas.ui.blank

import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlankFragment : BaseFragment<UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModel()

    //region Override BaseFragment methods
    override fun getLayoutId(): Int = R.layout.fragment_blank

    override fun setObservers() {}

    override fun setupView() {}
    //endregion
}
