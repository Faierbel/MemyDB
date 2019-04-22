package io.github.memydb.ui.modules.main

import android.view.View
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.contents.ImageContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_main.*

class MainItem(private val image: ImageContent) : AbstractItem<MainItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_main

    override val type: Int
        get() = R.id.itemMainImage

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<MainItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: MainItem, payloads: MutableList<Any>) {
            Glide.with(itemView)
                    .load(item.image.url)
                    .into(itemMainImage)
        }

        override fun unbindView(item: MainItem) {
        }
    }
}
