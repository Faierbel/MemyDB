package io.github.memydb.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.memydb.ui.base.ViewModelFactory

@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}