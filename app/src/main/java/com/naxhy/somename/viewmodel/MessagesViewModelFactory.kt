package com.naxhy.somename.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naxhy.somename.domain.messages.usecase.GetMessagesUseCase
import com.naxhy.somename.domain.messages.usecase.SendMessageUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class MessagesViewModelFactory @Inject constructor(
    private val getMessages: GetMessagesUseCase,
    private val sendMessage: SendMessageUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MessagesViewModel::class.java)) {
            return MessagesViewModel(getMessages, sendMessage) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}