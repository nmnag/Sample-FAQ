package com.naxhy.somename.domain.messages.usecase

import com.naxhy.somename.domain.core.CompletableWithParamUseCase
import com.naxhy.somename.domain.messages.model.Message
import com.naxhy.somename.domain.messages.repository.MessagesRepository
import io.reactivex.Completable

class SendMessageUseCase(private val repository: MessagesRepository) : CompletableWithParamUseCase<Message> {

    override fun execute(t: Message) = repository.sendMessage(t)
}