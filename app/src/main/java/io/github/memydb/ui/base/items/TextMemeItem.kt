package io.github.memydb.ui.base.items

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.TextContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_text_meme.*

class TextMemeItem(meme: Meme) : ModelAbstractItem<Meme, TextMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_text_meme

    override val type: Int
        get() = R.id.textMemeContent

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<TextMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: TextMemeItem, payloads: MutableList<Any>) {
            textMemeContent.text = (item.model.content as TextContent).url
            textMemePointText.text = item.model.points.toString()
            textMemeCommentText.text = item.model.commentAmount.toString()
        }

        override fun unbindView(item: TextMemeItem) {
        }

    }
}
