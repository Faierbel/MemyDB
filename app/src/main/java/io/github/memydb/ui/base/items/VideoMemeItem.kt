package io.github.memydb.ui.base.items

import android.net.Uri
import android.view.View
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.VideoContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_video_meme.*

class VideoMemeItem(meme: Meme) : ModelAbstractItem<Meme, VideoMemeItem.ViewHolder>(meme) {

    override val layoutRes: Int
        get() = R.layout.item_video_meme

    override val type: Int
        get() = R.id.videoMemeContent

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<VideoMemeItem>(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        override fun bindView(item: VideoMemeItem, payloads: MutableList<Any>) {
            val player = ExoPlayerFactory.newSimpleInstance(itemView.context)
            videoMemeContent.player = player

            val mediaSource = ProgressiveMediaSource.Factory(DefaultHttpDataSourceFactory("memy-db"))
                .createMediaSource(Uri.parse((item.model.content as VideoContent).url))
            player.prepare(mediaSource, true, true)


            videoMemePointText.text = item.model.points.toString()
            videoMemeCommentText.text = item.model.commentAmount.toString()
        }

        override fun unbindView(item: VideoMemeItem) {
        }

    }
}
