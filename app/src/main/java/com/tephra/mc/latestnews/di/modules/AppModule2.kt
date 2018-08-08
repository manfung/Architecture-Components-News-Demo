package com.tephra.mc.latestnews.di.modules

import android.content.Context
import com.tephra.mc.latestnews.LatestNewsApp
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = arrayOf(AndroidSupportInjectionModule::class, ViewModelModule::class, ServiceModule::class, ActivityModule::class))
abstract class AppModule2 {

    @Singleton
    @Binds
    @AppContext
    abstract fun provideContext(app: LatestNewsApp): Context
}


@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AppContext