package io.github.memydb.ui.modules.ninegag

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class NinegagFragment : Fragment() {

    companion object {
        fun newInstance() = NinegagFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.ninegag_title)
    }
}