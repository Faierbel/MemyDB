package io.github.memydb.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.memydb.ui.modules.anonimowe.AnonimoweFragment
import io.github.memydb.ui.modules.codinglove.CodingloveFragment
import io.github.memydb.ui.modules.demotywatory.ContentFragment
import io.github.memydb.ui.modules.demotywatory.DemotywatoryFragment
import io.github.memydb.ui.modules.jbzd.JbzdFragment
import io.github.memydb.ui.modules.kwejk.KwejkFragment
import io.github.memydb.ui.modules.main.MainActivity
import io.github.memydb.ui.modules.mistrzowie.MistrzowieFragment
import io.github.memydb.ui.modules.ninegag.NinegagFragment
import io.github.memydb.ui.modules.ninegagnsfw.NinegagnsfwFragment
import io.github.memydb.ui.modules.splash.SplashActivity

@Suppress("unused")
@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDemotywatoryFragment(): DemotywatoryFragment

    @ContributesAndroidInjector
    abstract fun bindKwejkFragment(): KwejkFragment

    @ContributesAndroidInjector
    abstract fun bindJbzdFragment(): JbzdFragment

    @ContributesAndroidInjector
    abstract fun bindNinegagFragment(): NinegagFragment

    @ContributesAndroidInjector
    abstract fun bindNinegagnsfwFragment(): NinegagnsfwFragment

    @ContributesAndroidInjector
    abstract fun bindMistrzowieFragment(): MistrzowieFragment

    @ContributesAndroidInjector
    abstract fun bindAnonimoweFragment(): AnonimoweFragment

    @ContributesAndroidInjector
    abstract fun bindCodingloveFragment(): CodingloveFragment

    @ContributesAndroidInjector
    abstract fun bindContentFragment(): ContentFragment
}
