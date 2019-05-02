package io.github.memydb.utils

import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.scroll.EndlessRecyclerOnScrollListener

inline fun RecyclerView.setEndlessOnScrollListener(visibleThreshold: Int, crossinline listener: () -> Unit) {
    layoutManager?.let {
        addOnScrollListener(object : EndlessRecyclerOnScrollListener(it, visibleThreshold) {
            override fun onLoadMore(currentPage: Int) {
                listener()
            }
        })
    }
}
