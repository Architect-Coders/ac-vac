package com.example.vacunas.ui.user.editing

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.vacunas.R
import com.example.vacunas.base.ui.*
import com.example.vacunas.base.utils.toInt
import com.example.vacunas.ui.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_editing_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class UserEditingFragment : BaseFragment<UserEditingViewModel>() {

    override val viewModel: UserEditingViewModel by viewModel()

    private val calendarDialog: DatePickerDialog by lazy {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                viewModel.onBirthdateSelected(cal.timeInMillis)
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )
    }


    //region Lifecycle methods
    override fun getLayoutId(): Int = R.layout.fragment_editing_user

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
        setListener()
    }

    private fun setObservers() {
        viewModel.getViewCommand().observe(viewLifecycleOwner, Observer {
            when (it) {
                is BaseViewCommand.OpenDatePickerDialog -> openPickerDialog()
                is BaseViewCommand.BackNavigate -> findNavController().navigateUp()
                is BaseViewCommand.ShowToast -> context?.toast(it.msg, it.largeDuration.toInt())
            }
        })

        viewModel.visibleBottomAppBar.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleBottomAppBarVisibility(it)
        })

        viewModel.visibleFabButton.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleFabButtonVisibility(it)
        })

        viewModel.birthDate.observe(viewLifecycleOwner, Observer {
            userBirthdateInput.content = it
        })
    }

    private fun setListener() {
        userNameInput.addTextChangedListener {
            viewModel.onAfterNameTextChanged(it as CharSequence)
        }

        userBirthdateInput.setOnSimpleClickListener(viewModel::onBirthdateClicked)

        userBloodTypeInput.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                viewModel.onBloodTypeSelected(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        userRegionInput.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                viewModel.onRegionSelected(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        userCancelOption.setOnSimpleClickListener(viewModel::onCancelClicked)
        userOkOption.setOnSimpleClickListener(viewModel::onOkClicked)
    }

    private fun openPickerDialog() {
        calendarDialog.show()
    }
    //endregion
}