package com.example.vacunas.ui.user

import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunas.R
import com.example.vacunas.base.ui.BaseFragment
import com.example.vacunas.base.ui.bindView
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment<UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModel()

    private val userListView: RecyclerView by bindView(R.id.fragment_user_list_recycler)

    private val listAdapter: UserListAdapter<UserListViewModel> by lazy { UserListAdapter(viewModel) }

    //region Override BaseFragment methods
    override fun getLayoutId(): Int = R.layout.fragment_list_users

    override fun setObservers() {
        viewModel.users.observe(this, Observer {
            listAdapter.submitList(it)
        })
    }

    override fun setupView() {
        userListView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            adapter = this@UserListFragment.listAdapter
        }
    }
    //endregion
}
