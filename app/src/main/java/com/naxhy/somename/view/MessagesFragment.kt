package com.naxhy.somename.view


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.naxhy.somename.MainActivityFragmentsListener
import com.naxhy.somename.R
import com.naxhy.somename.core.injector
import com.naxhy.somename.domain.messages.model.Message
import com.naxhy.somename.viewmodel.MessagesViewModel
import com.naxhy.somename.viewmodel.MessagesViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MessagesFragment : Fragment() {

    companion object {
        const val ARG_USERNAME = "arg_username"

        fun newInstance(username: String): MessagesFragment {
            val args = Bundle()

            args.putString(ARG_USERNAME, username)

            val fragment = MessagesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject lateinit var factory: MessagesViewModelFactory
     lateinit var viewModel: MessagesViewModel


    private lateinit var messagesList: RecyclerView
    private lateinit var adapter: MessagesAdapter

    private lateinit var sendMessage: Button
    private lateinit var message: EditText

    private lateinit var username: String

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(MessagesViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_chat, container, false)

        username = requireNotNull(arguments).getString(ARG_USERNAME)!!

        sendMessage = view.findViewById(R.id.send)
        message = view.findViewById(R.id.message)
        messagesList = view.findViewById(R.id.message_list)

        val manager = LinearLayoutManager(context)
        manager.reverseLayout = true
        messagesList.layoutManager = manager

        adapter = MessagesAdapter(username, listOf())
        messagesList.adapter = adapter

        sendMessage.setOnClickListener {
            val chatMessage = Message(
                message.text.toString(),
                username,
                System.currentTimeMillis()
            )
            message.setText("")

            disposables.add(
                viewModel.sendMessage(chatMessage)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { Log.d("MessagesFragment", "Message sent") },
                        { showInternetError() }
                    )
            )
        }

        addMessageBoxTextListener()

        disposables.add(
            viewModel.getMessages()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { adapter.updateData(it) },
                    { showInternetError() }
                )
        )

        return view
    }

    private fun showInternetError() {
        Toast.makeText(context, getString(R.string.internet_connection_error), Toast.LENGTH_SHORT).show()
    }

    private fun addMessageBoxTextListener() {
        message.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                sendMessage.isEnabled = s.isNotEmpty()
            }
        })
    }

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}