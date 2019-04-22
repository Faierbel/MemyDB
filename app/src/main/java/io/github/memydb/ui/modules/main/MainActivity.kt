package io.github.memydb.ui.modules.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import io.github.memydb.R
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.contents.Content.Type.IMAGE
import io.github.memydb.data.pojos.contents.ImageContent
import io.github.memydb.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        val itemAdapter = ItemAdapter.items<MainItem>()
        val adapter = FastAdapter.with(itemAdapter)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = adapter

        mainViewModel.demotywatoryPage.observe(this, Observer { response ->
            if (response is ApiResponse.SuccessApiResponse) {
                val page = response.value

                val imageContentMemes = page.memes.filter { it.content.contentType == IMAGE }.map { it.content }

                itemAdapter.setNewList(imageContentMemes.map { MainItem(it as ImageContent) })
            }
        })
    }
}
