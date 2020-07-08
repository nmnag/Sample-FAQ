package com.naxhy.somename.core

import android.app.Application
import com.naxhy.somename.data.core.DatabaseModule
import com.naxhy.somename.data.core.RepositoryModule

lateinit var injector: AppComponent


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule())
            .repositoryModule(RepositoryModule())
            .viewModelModule(ViewModelModule())
            .build()
    }
}

