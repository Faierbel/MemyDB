package io.github.memydb.ui.modules.kwejk

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class KwejkFragment : Fragment() {

    companion object {
        fun newInstance() = KwejkFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.kwejk_title)
    }
}