package io.github.memydb.ui.modules.codinglove

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
import kotlinx.android.synthetic.main.fragment_codinglove.*
import javax.inject.Inject

class CodingloveFragment : BaseFragment(R.layout.fragment_codinglove) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val codingloveViewModel: CodingloveViewModel by viewModels { viewModelFactory }

    private lateinit var codingloveAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.thecodinglove_title)
        initView()
    }

    private fun initView() {
        codingloveViewModel.initialize()
        codingloveViewModel.codingloveMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        codingloveAdapter = FastAdapter.with(memesAdapter)

        codingloveRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = codingloveAdapter
            setEndlessOnScrollListener(15) { codingloveViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
