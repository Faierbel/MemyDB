package io.github.memydb.ui.modules.ninegagnsfw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import kotlinx.android.synthetic.main.ninegagnsfw_fragment.*
import javax.inject.Inject

class NinegagnsfwFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var ninegagnsfwViewModel: NinegagnsfwViewModel

    private lateinit var ninegagnsfwAdapter: FastAdapter<AbstractItem<*>>

    private var savedView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedView == null) {
            savedView = inflater.inflate(R.layout.ninegagnsfw_fragment, container, false)
        }
        return savedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.ninegagnsfw_title)
        ninegagnsfwViewModel = ViewModelProviders.of(this, viewModelFactory).get(NinegagnsfwViewModel::class.java)
        initView()
    }

    private fun initView() {
        ninegagnsfwViewModel.initialize()
        ninegagnsfwViewModel.ninegagnsfwMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        ninegagnsfwAdapter = FastAdapter.with(memesAdapter)

        ninegagnsfwRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ninegagnsfwAdapter
            setEndlessOnScrollListener(15) { ninegagnsfwViewModel.downloadNextPage() }
            itemAnimator = null
        }

    }
}
