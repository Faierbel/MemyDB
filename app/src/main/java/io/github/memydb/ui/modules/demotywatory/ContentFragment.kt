package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.ImageContent
import io.github.memydb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_content.*

class ContentFragment : BaseFragment() {

    private val argument: ContentFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this)
            .load(((argument.meme as Meme).content as ImageContent).url)
            .into(contentImage)
    }
}
