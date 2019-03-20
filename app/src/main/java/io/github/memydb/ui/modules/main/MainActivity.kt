package io.github.memydb.ui.modules.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
