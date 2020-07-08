package com.naxhy.somename.data.core

import com.naxhy.somename.data.messages.MessagesRepositoryImpl
//import com.naxhy.somename.data.user.AuthRepositoryImpl
import com.naxhy.somename.domain.messages.repository.MessagesRepository
//import com.naxhy.somename.domain.user.repository.AuthRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesMessagesRepository(repository: MessagesRepositoryImpl): MessagesRepository {
        return repository
    }
}