package io.github.memydb.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.memydb.ui.modules.main.MainActivity
import io.github.memydb.ui.modules.splash.SplashActivity

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}