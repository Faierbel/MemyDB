package io.github.memydb.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import io.github.memydb.ui.base.ViewModelFactory
import io.github.memydb.ui.modules.demotywatory.DemotywatoryViewModel

@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ClassKey(DemotywatoryViewModel::class)
    abstract fun bindDemotywatoryViewModel(viewModel: DemotywatoryViewModel): ViewModel

}
