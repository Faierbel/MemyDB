package io.github.memydb.ui.modules.jbzd

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
import kotlinx.android.synthetic.main.fragment_jbzd.*
import javax.inject.Inject

class JbzdFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var jbzdViewModel: JbzdViewModel

    private lateinit var jbzdAdapter: FastAdapter<AbstractItem<*>>

    private var savedView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedView == null) {
            savedView = inflater.inflate(R.layout.fragment_jbzd, container, false)
        }
        return savedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.jbzd_title)
        jbzdViewModel = ViewModelProviders.of(this, viewModelFactory).get(JbzdViewModel::class.java)
        initView()
    }

    private fun initView() {
        jbzdViewModel.initialize()
        jbzdViewModel.jbzdMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        jbzdAdapter = FastAdapter.with(memesAdapter)

        jbzdRecyler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = jbzdAdapter
            setEndlessOnScrollListener(15) { jbzdViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}
