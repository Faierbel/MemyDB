package io.github.memydb.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.memydb.MemyDBApp

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<MemyDBApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MemyDBApp>()
}