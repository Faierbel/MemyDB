package io.github.memydb.ui.base.items

import android.view.View
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.GIFContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_gif_meme.*

class GifMemeItem(meme: Meme) : ModelAbstractItem<Meme, GifMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_gif_meme

    override val type: Int
        get() = R.id.gifMemeCommentImage

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<GifMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: GifMemeItem, payloads: MutableList<Any>) {
            gifMemeCommentText.text = item.model.commentAmount.toString()
            gifMemePointText.text = item.model.points.toString()
            Glide.with(itemView)
                .asGif()
                .load((item.model.content as GIFContent).url)
                .into(gifMemeContent)
        }

        override fun unbindView(item: GifMemeItem) {
            Glide.with(itemView).clear(gifMemeContent)
        }

    }
}
