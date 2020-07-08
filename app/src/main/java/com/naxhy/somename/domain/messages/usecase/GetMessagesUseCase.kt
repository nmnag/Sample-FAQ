package com.naxhy.somename.domain.messages.usecase


import com.naxhy.somename.domain.core.ObservableUseCase
import com.naxhy.somename.domain.messages.model.Message
import com.naxhy.somename.domain.messages.repository.MessagesRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(private val repository: MessagesRepository) : ObservableUseCase<List<Message>> {

    override fun execute() = repository.getMessages()
}