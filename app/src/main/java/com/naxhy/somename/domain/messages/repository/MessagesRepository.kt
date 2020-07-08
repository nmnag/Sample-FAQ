package com.naxhy.somename.domain.messages.repository

import com.naxhy.somename.domain.messages.model.Message
import io.reactivex.Completable
import io.reactivex.Observable


interface MessagesRepository {


    fun sendMessage(message: Message): Completable

    fun getMessages(): Observable<List<Message>>
}