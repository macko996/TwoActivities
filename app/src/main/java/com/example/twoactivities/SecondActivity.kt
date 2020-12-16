package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

const val EXTRA_REPLY = "com.example.twoactivities.REPLY"
private const val LOG_TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {

    private lateinit var received_message_textView : TextView
    private lateinit var reply_button : Button
    private lateinit var reply_message_editText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        received_message_textView = findViewById(R.id.received_message_textview)
        reply_button = findViewById(R.id.reply_button)
        reply_message_editText = findViewById(R.id.reply_message_editText)

        val parentIntent = intent
        val received_message = parentIntent.getStringExtra(MESSAGE).toString()
        received_message_textView.text = received_message

        reply_button.setOnClickListener{
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY,reply_message_editText.text.toString())
            setResult(Activity.RESULT_OK,replyIntent)
            Log.d(LOG_TAG, "End SecondActivity");
            finish()
        }

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestoy");
    }

}