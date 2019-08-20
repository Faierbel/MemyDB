package io.github.memydb.ui.modules.anonimowe

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
import kotlinx.android.synthetic.main.fragment_anonimowe.*
import javax.inject.Inject

class AnonimoweFragment : BaseFragment(R.layout.fragment_anonimowe) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var anonimoweViewModel: AnonimoweViewModel

    private lateinit var anonimoweAdapter: FastAdapter<AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.anonimowe_title)
        anonimoweViewModel = ViewModelProviders.of(this, viewModelFactory).get(AnonimoweViewModel::class.java)
        initView()
    }

    private fun initView() {
        anonimoweViewModel.initialize()
        anonimoweViewModel.anonimoweMemes.observe(viewLifecycleOwner, Observer {
            memesAdapter.setNewList(it)
        })

        anonimoweAdapter = FastAdapter.with(memesAdapter)

        anonimoweRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = anonimoweAdapter
            setEndlessOnScrollListener(15) { anonimoweViewModel.downloadNextPage() }
            itemAnimator = null
        }
    }
}