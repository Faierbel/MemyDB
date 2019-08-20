package io.github.memydb.ui.modules.kwejk

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.base.BaseFragment
import io.github.memydb.ui.base.ViewModelFactory
import io.github.memydb.utils.setEndlessOnScrollListener
import kotlinx.android.synthetic.main.fragment_kwejk.*
import javax.inject.Inject

class KwejkFragment : BaseFragment(R.layout.fragment_kwejk) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val kwejkViewModel: KwejkViewModel by viewModels { viewModelFactory }

    private lateinit var kwejkAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.kwejk_title)
        initView()
    }

    private fun initView() {
        kwejkViewModel.initialize()
        kwejkViewModel.kwejkMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        kwejkAdapter = FastAdapter.with(memesAdapter)

        kwejkRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = kwejkAdapter
            setEndlessOnScrollListener(15) { kwejkViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
