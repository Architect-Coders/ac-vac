package com.example.vacunas.ui.user.list

import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.base.ui.visible
import com.example.vacunas.ui.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_list_users.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment<UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModel()

    private val listAdapter: UserListAdapter<UserListViewModel> by lazy {
        UserListAdapter(viewModel)
    }

    //region Lifecycle methods
    override fun getLayoutId(): Int = R.layout.fragment_list_users

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
        setupView()
    }

    private fun setObservers() {
        viewModel.viewUsersList.observe(viewLifecycleOwner, Observer {
            // TODO: QUITAR
            println(">>> observer user list; size = ${it.size}")
            println(">>> list sort = $it")
            listAdapter.submitList(it)
        })

        viewModel.viewUserListEmptyTextVisible.observe(viewLifecycleOwner, Observer {
            userListMsg.visible = it
        })

        viewModel.viewUserListVisible.observe(viewLifecycleOwner, Observer {
            userListView.visible = it
        })

        viewModel.visibleBottomAppBar.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleBottomAppBar(it)
        })

        viewModel.visibleFabButton.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).toggleFabButton(it)
        })
    }

    private fun setupView() {
        userListView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            adapter = this@UserListFragment.listAdapter
        }
    }
    //endregion
}
