package com.tephra.mc.latestnews.di.modules

import dagger.Module
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import androidx.lifecycle.ViewModel
import com.tephra.mc.latestnews.di.ViewModelFactory
import com.tephra.mc.latestnews.di.ViewModelKey
import com.tephra.mc.latestnews.ui.topheadlines.TopHeadlinesViewModel

import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TopHeadlinesViewModel::class)
    internal abstract fun bindTopHeadlinesViewModel(topHeadlinesViewModel: TopHeadlinesViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
