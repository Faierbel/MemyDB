package io.github.memydb.ui.base

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.mikepenz.fastadapter.adapters.ModelAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import dagger.android.support.DaggerFragment
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.Content
import io.github.memydb.ui.base.items.*

open class BaseFragment : DaggerFragment() {

    protected lateinit var memesAdapter: ModelAdapter<Meme, AbstractItem<*>>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        memesAdapter = ModelAdapter {
            when (it.content.contentType) {
                Content.Type.IMAGE -> ImageMemeItem(it)
                Content.Type.CAPTIONED_GALLERY -> CaptionedGalleryMemeItem(it)
                Content.Type.GALLERY -> GalleryMemeItem(it)
                Content.Type.GIF -> GifMemeItem(it)
                Content.Type.PREVIEW -> PreviewMemeItem(it)
                Content.Type.TEXT -> TextMemeItem(it)
                Content.Type.VIDEO -> VideoMemeItem(it)
            }
        }
    }

    open fun showMessage(text: String) {
        Toast.makeText(context, text, LENGTH_LONG).show()
    }
}
