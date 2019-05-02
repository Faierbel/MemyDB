package io.github.memydb.ui.modules.mistrzowie

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
import kotlinx.android.synthetic.main.fragment_mistrzowie.*
import javax.inject.Inject

class MistrzowieFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mistrzowieViewModel: MistrzowieViewModel

    private lateinit var mistrzowieAdapter: FastAdapter<AbstractItem<*>>

    private var savedView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedView == null) {
            savedView = inflater.inflate(R.layout.fragment_mistrzowie, container, false)
        }
        return savedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.mistrzowie_title)
        mistrzowieViewModel = ViewModelProviders.of(this, viewModelFactory).get(MistrzowieViewModel::class.java)
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
