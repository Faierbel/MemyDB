package io.github.memydb.ui.modules.ninegag

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
import kotlinx.android.synthetic.main.ninegag_fragment.*
import javax.inject.Inject

class NinegagFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var ninegagViewModel: NinegagViewModel

    private lateinit var ninegagAdapter: FastAdapter<AbstractItem<*>>

    private var savedView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedView == null) {
            savedView = inflater.inflate(R.layout.ninegag_fragment, container, false)
        }
        return savedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.ninegag_title)
        ninegagViewModel = ViewModelProviders.of(this, viewModelFactory).get(NinegagViewModel::class.java)
        initView()
    }

    private fun initView() {
        ninegagViewModel.initialize()
        ninegagViewModel.ninegagyMemes.observe(viewLifecycleOwner, Observer {
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
