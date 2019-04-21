package io.github.memydb

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.memydb.di.DaggerAppComponent

class MemyDBApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}