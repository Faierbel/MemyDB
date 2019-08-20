package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.ImageContent
import io.github.memydb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_content.*

class ContentFragment : BaseFragment(R.layout.fragment_content) {

    private val argument: ContentFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this)
            .load(((argument.meme as Meme).content as ImageContent).url)
            .into(contentImage)
    }
}
