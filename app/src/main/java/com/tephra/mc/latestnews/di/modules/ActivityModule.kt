package com.tephra.mc.latestnews.di.modules

import com.tephra.mc.latestnews.ui.topheadlines.TopHeadlinesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun topHeadlinesActivity(): TopHeadlinesActivity

}