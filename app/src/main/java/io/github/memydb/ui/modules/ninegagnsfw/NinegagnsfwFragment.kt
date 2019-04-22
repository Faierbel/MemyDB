package io.github.memydb.ui.modules.ninegagnsfw

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class NinegagnsfwFragment : Fragment() {

    companion object {
        fun newInstance() = NinegagnsfwFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.ninegagnsfw_title)
    }
}