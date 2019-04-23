package io.github.memydb.ui.modules.demotywatory

import android.view.View
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.contents.ImageContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.demotywatory_item.*

class DemotywatoryItem(private val imageContent: ImageContent) : AbstractItem<DemotywatoryItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.demotywatory_item

    override val type: Int
        get() = R.id.itemDemotImage

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<DemotywatoryItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: DemotywatoryItem, payloads: MutableList<Any>) {
            Glide.with(itemView)
                .load(item.imageContent.url)
                .into(itemDemotImage)
        }


        override fun unbindView(item: DemotywatoryItem) {

        }
    }
}
