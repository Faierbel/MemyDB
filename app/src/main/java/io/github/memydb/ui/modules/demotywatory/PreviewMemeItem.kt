package io.github.memydb.ui.modules.demotywatory

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import kotlinx.android.extensions.LayoutContainer

class PreviewMemeItem(meme: Meme) : ModelAbstractItem<Meme, PreviewMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_image_meme

    override val type: Int
        get() = 4

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<PreviewMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: PreviewMemeItem, payloads: MutableList<Any>) {
        }

        override fun unbindView(item: PreviewMemeItem) {
        }

    }
}
