package com.tephra.mc.latestnews.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, ServiceModule::class, ActivityModule::class])
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application = app
}