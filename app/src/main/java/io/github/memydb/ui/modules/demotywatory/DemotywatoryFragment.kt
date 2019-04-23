package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import io.github.memydb.R
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.contents.Content
import io.github.memydb.data.pojos.contents.ImageContent
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.base.BaseFragment
import io.github.memydb.ui.base.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_demotywatory.*
import javax.inject.Inject

class DemotywatoryFragment : BaseFragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    private lateinit var demotywatoryViewModel: DemotywatoryViewModel

    private lateinit var fastAdapter: FastAdapter<DemotywatoryItem>

    private lateinit var itemAdapter: ItemAdapter<DemotywatoryItem>

    companion object {
        fun newInstance() = DemotywatoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_demotywatory, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.demotywatory_title)

        demotywatoryViewModel = ViewModelProviders.of(this, viewmodelFactory)
            .get(DemotywatoryViewModel::class.java)

        itemAdapter = ItemAdapter.items()
        fastAdapter = FastAdapter.with(itemAdapter)
        demotRecyler.layoutManager = LinearLayoutManager(context)
        demotRecyler.adapter = fastAdapter

        demotywatoryViewModel.demotywatoryPage.observe(this, Observer {
            if (it is ApiResponse.SuccessApiResponse) {
                val imageItems = it.value.memes.filter { meme -> meme.content.contentType == Content.Type.IMAGE }
                    .map { meme -> DemotywatoryItem(meme.content as ImageContent) }

                itemAdapter.setNewList(imageItems)
            }
        })

        demotywatoryViewModel.demotywatoryPage.refresh()

    }
}
