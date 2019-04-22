package io.github.memydb.ui.modules.mistrzowie

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class MistrzowieFragment : Fragment() {

    companion object {
        fun newInstance() = MistrzowieFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? BaseActivity)?.supportActionBar?.title = getString(R.string.mistrzowie_title)
    }
}