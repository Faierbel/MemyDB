package io.github.memydb.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import io.github.memydb.ui.base.ViewModelFactory
import io.github.memydb.ui.modules.anonimowe.AnonimoweViewModel
import io.github.memydb.ui.modules.codinglove.CodingloveViewModel
import io.github.memydb.ui.modules.demotywatory.DemotywatoryViewModel
import io.github.memydb.ui.modules.jbzd.JbzdViewModel
import io.github.memydb.ui.modules.kwejk.KwejkViewModel
import io.github.memydb.ui.modules.mistrzowie.MistrzowieViewModel
import io.github.memydb.ui.modules.ninegag.NinegagViewModel
import io.github.memydb.ui.modules.ninegagnsfw.NinegagnsfwViewModel

@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ClassKey(DemotywatoryViewModel::class)
    abstract fun bindDemotywatoryViewModel(viewModel: DemotywatoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(KwejkViewModel::class)
    abstract fun bindKwejkViewModel(viewModel: KwejkViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(JbzdViewModel::class)
    abstract fun bindJbzdViewModel(viewModel: JbzdViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(NinegagViewModel::class)
    abstract fun bindNinegagViewModel(viewModel: NinegagViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(NinegagnsfwViewModel::class)
    abstract fun bindNinegagnsfwViewModel(viewModel: NinegagnsfwViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(MistrzowieViewModel::class)
    abstract fun bindMistrzowieViewModel(viewModel: MistrzowieViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(AnonimoweViewModel::class)
    abstract fun bindAnonimoweViewModel(viewModel: AnonimoweViewModel): ViewModel

    @Binds
    @IntoMap
    @ClassKey(CodingloveViewModel::class)
    abstract fun bindCodingloveViewModel(viewModel: CodingloveViewModel): ViewModel
}
