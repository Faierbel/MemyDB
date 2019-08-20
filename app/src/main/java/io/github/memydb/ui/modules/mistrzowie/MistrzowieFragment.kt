package io.github.memydb.ui.modules.mistrzowie

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
import kotlinx.android.synthetic.main.fragment_mistrzowie.*
import javax.inject.Inject

class MistrzowieFragment : BaseFragment(R.layout.fragment_mistrzowie) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val mistrzowieViewModel: MistrzowieViewModel by viewModels { viewModelFactory }

    private lateinit var mistrzowieAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.mistrzowie_title)
        initView()
    }

    private fun initView() {
        mistrzowieViewModel.initialize()
        mistrzowieViewModel.mistrzowieMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        mistrzowieAdapter = FastAdapter.with(memesAdapter)

        mistrzowieRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mistrzowieAdapter
            setEndlessOnScrollListener(15) { mistrzowieViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
