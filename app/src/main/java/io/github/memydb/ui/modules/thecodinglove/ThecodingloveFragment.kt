package io.github.memydb.ui.modules.thecodinglove

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class ThecodingloveFragment : Fragment() {

    companion object {
        fun newInstance() = ThecodingloveFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.thecodinglove_title)
    }
}
