package com.example.vacunas.ui.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.ui.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : BaseFragment<DetailViewModel>() {

    companion object {
        const val ARG_USERID = "userId"
    }

    override val viewModel: DetailViewModel by viewModel {
        parametersOf(arguments?.getInt(ARG_USERID, -1) ?: -1)
    }


    //region Lifecycle methods
    override fun getLayoutId(): Int = R.layout.fragment_detail

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
        setupView()
    }

    fun setObservers() {
        viewModel.visibleBottomAppBar.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleBottomAppBarVisibility(it)
        })

        viewModel.visibleFabButton.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleFabButtonVisibility(it)
        })

        viewModel.userView.observe(viewLifecycleOwner, Observer {
            userNameText.text = it.name
            userBirthDateText.text = it.birthDate
            userBloodTypeValue.text = it.bloodType
            userRegionValue.text = it.region
        })
    }

    fun setupView() {

    }
    //endregion
}