package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.github.memydb.R
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.pojos.contents.ImageContent
import io.github.memydb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_content.*

class ContentFragment : BaseFragment() {

    companion object {
        private const val MEME_ARGUMENT = "memeArgument"

        fun newInstance(meme: Meme): ContentFragment {
            return ContentFragment().apply {
                arguments = Bundle().apply { putSerializable(MEME_ARGUMENT, meme) }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.getSerializable(MEME_ARGUMENT)?.let {
            Glide.with(this)
                .load(((it as Meme).content as ImageContent).url)
                .into(contentImage)
        }
    }
}