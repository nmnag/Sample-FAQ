package com.naxhy.somename.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import com.naxhy.somename.domain.messages.model.Message
import com.naxhy.somename.domain.messages.usecase.GetMessagesUseCase
import com.naxhy.somename.domain.messages.usecase.SendMessageUseCase
import javax.inject.Inject

class MessagesViewModel  @Inject constructor ( private val getMessages: GetMessagesUseCase,
                        private val sendMessage: SendMessageUseCase) : ViewModel() {

    fun sendMessage(message: Message) = sendMessage.execute(message)

    fun getMessages() = getMessages.execute()
}