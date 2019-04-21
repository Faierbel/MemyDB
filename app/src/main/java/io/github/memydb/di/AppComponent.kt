package io.github.memydb.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.memydb.MemyDBApp
import io.github.memydb.data.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<MemyDBApp> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<MemyDBApp>
}