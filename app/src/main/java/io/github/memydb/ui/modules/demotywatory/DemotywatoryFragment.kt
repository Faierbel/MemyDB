package io.github.memydb.ui.modules.demotywatory

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class DemotywatoryFragment : Fragment() {

    companion object {
        fun newInstance() = DemotywatoryFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.demotywatory_title)
    }
}