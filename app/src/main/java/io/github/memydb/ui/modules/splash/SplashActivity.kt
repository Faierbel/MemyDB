package io.github.memydb.ui.modules.splash

import android.os.Bundle
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.modules.main.MainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }
}