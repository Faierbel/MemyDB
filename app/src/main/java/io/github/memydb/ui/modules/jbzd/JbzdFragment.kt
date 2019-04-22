package io.github.memydb.ui.modules.jbzd

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class JbzdFragment : Fragment() {

    companion object {
        fun newInstance() = JbzdFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.jbzd_title)
    }
}