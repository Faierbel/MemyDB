package io.github.memydb.ui.base

import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {

    open fun showMessage(text: String) {
        Toast.makeText(context, text, LENGTH_LONG).show()
    }
}
