package io.github.memydb.ui.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.mikepenz.fastadapter.adapters.ModelAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.Content
import io.github.memydb.ui.base.items.*
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    protected lateinit var memesAdapter: ModelAdapter<Meme, AbstractItem<*>>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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

    override fun androidInjector() = androidInjector
}
