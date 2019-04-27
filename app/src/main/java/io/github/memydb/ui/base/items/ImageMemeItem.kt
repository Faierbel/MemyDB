package io.github.memydb.ui.base.items

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.ImageContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image_meme.*

class ImageMemeItem(meme: Meme) : ModelAbstractItem<Meme, ImageMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_image_meme

    override val type: Int
        get() = R.id.imageMemeContent

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<ImageMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: ImageMemeItem, payloads: MutableList<Any>) {
            imageMemeCommentText.text = item.model.commentAmount.toString()
            imageMemePointText.text = item.model.points.toString()
            Glide.with(itemView)
                .load((item.model.content as ImageContent).url)
                .into(DrawableImageViewTarget(imageMemeContent).waitForLayout())
        }

        override fun unbindView(item: ImageMemeItem) {
            Glide.with(itemView).clear(imageMemeContent)
        }

    }
}
