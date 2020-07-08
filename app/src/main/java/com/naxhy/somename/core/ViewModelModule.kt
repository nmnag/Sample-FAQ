package com.naxhy.somename.core

import com.naxhy.somename.data.core.RepositoryModule
import com.naxhy.somename.viewmodel.MessagesViewModelFactory
import com.naxhy.somename.data.messages.MessagesRepositoryImpl
//import com.imakeanapp.data.user.AuthRepositoryImpl
import com.naxhy.somename.domain.messages.usecase.GetMessagesUseCase
import com.naxhy.somename.domain.messages.usecase.SendMessageUseCase
//import com.imakeanapp.domain.user.usecase.LoginUseCase
//import com.imakeanapp.domain.user.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides

@Module (includes = [RepositoryModule::class])
class ViewModelModule {


    @Provides
    fun providesMessagesViewModelFactory(repository: MessagesRepositoryImpl): MessagesViewModelFactory {
        return MessagesViewModelFactory(
            GetMessagesUseCase(repository),
            SendMessageUseCase(repository)
        )
    }
}