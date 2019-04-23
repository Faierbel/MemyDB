package io.github.memydb.ui.modules.demotywatory

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import kotlinx.android.extensions.LayoutContainer

class TextMemeItem(meme: Meme) : ModelAbstractItem<Meme, TextMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_image_meme

    override val type: Int
        get() = 5

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<TextMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: TextMemeItem, payloads: MutableList<Any>) {
        }

        override fun unbindView(item: TextMemeItem) {
        }

    }
}
