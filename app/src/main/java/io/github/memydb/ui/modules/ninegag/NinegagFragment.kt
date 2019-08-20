package io.github.memydb.ui.modules.ninegag

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.base.BaseFragment
import io.github.memydb.ui.base.ViewModelFactory
import io.github.memydb.utils.setEndlessOnScrollListener
import kotlinx.android.synthetic.main.ninegag_fragment.*
import javax.inject.Inject

class NinegagFragment : BaseFragment(R.layout.ninegag_fragment) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var ninegagViewModel: NinegagViewModel

    private lateinit var ninegagAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.ninegag_title)
        ninegagViewModel = ViewModelProviders.of(this, viewModelFactory).get(NinegagViewModel::class.java)
        initView()
    }

    private fun initView() {
        ninegagViewModel.initialize()
        ninegagViewModel.ninegagMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        ninegagAdapter = FastAdapter.with(memesAdapter)

        ninegagRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ninegagAdapter
            setEndlessOnScrollListener(15) { ninegagViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
