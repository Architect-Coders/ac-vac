package com.example.vacunas.base.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    abstract val viewModel: T

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // This callback will only be called when the fragment is at least Started.
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            enabled = true,
            onBackPressed = onBackPressed()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(getLayoutId(), container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onDestroyView() {
        lifecycle.removeObserver(viewModel)
        super.onDestroyView()
    }

    open fun onBackPressed(): OnBackPressedCallback.() -> Unit = {
        isEnabled = false
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }
    //endregion

    abstract fun getLayoutId(): Int
}
