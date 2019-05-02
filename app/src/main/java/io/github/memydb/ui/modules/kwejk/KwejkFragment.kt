package io.github.memydb.ui.modules.kwejk

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
import kotlinx.android.synthetic.main.fragment_kwejk.*
import javax.inject.Inject

class KwejkFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var kwejkViewModel: KwejkViewModel

    private lateinit var kwejkAdapter: FastAdapter<AbstractItem<*>>

    private var savedView: View? = null

    companion object {
        fun newInstance() = KwejkFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedView == null) {
            savedView = inflater.inflate(R.layout.fragment_kwejk, container, false)
        }
        return savedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.kwejk_title)
        kwejkViewModel = ViewModelProviders.of(this, viewModelFactory).get(KwejkViewModel::class.java)
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
