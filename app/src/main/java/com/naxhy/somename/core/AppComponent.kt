package com.naxhy.somename.core

import com.google.firebase.firestore.FirebaseFirestore
//import com.imakeanapp.chatappkotlin.auth.viewmodel.AuthViewModelFactory
import com.naxhy.somename.viewmodel.MessagesViewModelFactory
import com.naxhy.somename.data.core.DatabaseModule
import com.naxhy.somename.data.core.RepositoryModule
import com.naxhy.somename.domain.messages.repository.MessagesRepository
//import com.imakeanapp.domain.user.repository.AuthRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
//    RepositoryModule::class,
    DatabaseModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponent {

//    fun authViewModelFactory(): AuthViewModelFactory

    fun messagesViewModelFactory(): MessagesViewModelFactory

//    fun authRepository(): AuthRepository

    fun messagesRepository(): MessagesRepository

    fun firebaseFirestore(): FirebaseFirestore
}