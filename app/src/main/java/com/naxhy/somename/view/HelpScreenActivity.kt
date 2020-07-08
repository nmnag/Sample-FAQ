package com.naxhy.somename.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naxhy.somename.R
import kotlinx.android.synthetic.main.activity_help_screen.*

class HelpScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_screen)

        button_oi.setOnClickListener(){
            showChatFragment("You")
        }
    }


    private fun showChatFragment(username: String) {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.animator.slide_in_from_right, R.animator.slide_out_to_left,
                R.animator.slide_in_from_left, R.animator.fade_out)
            replace(R.id.fragment_container, MessagesFragment.newInstance(username), "MessagesFragment")
            addToBackStack(null)
            commit()
        }
    }

}
