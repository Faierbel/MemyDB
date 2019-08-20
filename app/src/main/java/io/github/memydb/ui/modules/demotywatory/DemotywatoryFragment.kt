package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.base.BaseFragment
import io.github.memydb.ui.base.ViewModelFactory
import io.github.memydb.ui.base.items.ImageMemeItem
import io.github.memydb.utils.setEndlessOnScrollListener
import kotlinx.android.synthetic.main.fragment_demotywatory.*
import javax.inject.Inject

class DemotywatoryFragment : BaseFragment(R.layout.fragment_demotywatory) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var demotViewModel: DemotywatoryViewModel

    private lateinit var demotAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.demotywatory_title)
        demotViewModel = ViewModelProviders.of(this, viewModelFactory).get(DemotywatoryViewModel::class.java)
        initView()
    }

    private fun initView() {
        demotViewModel.initialize()
        demotViewModel.demotywatoryMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        demotAdapter = FastAdapter.with(memesAdapter)
        demotAdapter.onClickListener = { _, _, item, _ ->
            if (item is ImageMemeItem) {
                val action = DemotywatoryFragmentDirections.actionDemotywatoryFragmentToContentFragment(item.model)
                findNavController().navigate(action)
            }
            true
        }

        demotRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = demotAdapter
            setEndlessOnScrollListener(15) { demotViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
