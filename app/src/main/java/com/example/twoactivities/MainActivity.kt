package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val MESSAGE = "com.example.twoactivities.Message"
const val REQUEST_CODE = 0
private const val LOG_TAG = "MainActivity"
private const val SIS_REPLY_VISIBILITY = "reply_text"
private const val SIS_REPLY_TEXT = "reply_text"

class MainActivity : AppCompatActivity() {

  private lateinit var send_button : Button
  private lateinit var message_editText : EditText
  private lateinit var reply_head_textView: TextView
  private lateinit var reply_message_textView : TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    send_button = findViewById(R.id.send_button)
    message_editText = findViewById(R.id.send_message_editText)
    reply_message_textView = findViewById(R.id.reply_message_textview)
    reply_head_textView = findViewById(R.id.textView)

    if (savedInstanceState != null){
      Log.d(LOG_TAG,"Restoring view")
      val isVisible = savedInstanceState.getBoolean(SIS_REPLY_VISIBILITY)
      if (isVisible) {
        reply_head_textView.visibility = View.VISIBLE
        reply_message_textView.text = savedInstanceState.getString(SIS_REPLY_TEXT)
        reply_message_textView.visibility = View.VISIBLE
      }

    }

    send_button.setOnClickListener{
      val intent = Intent(this,SecondActivity::class.java)
      intent.putExtra(MESSAGE,message_editText.text.toString())
      startActivityForResult(intent, REQUEST_CODE)
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

  override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
    super.onSaveInstanceState(outState, outPersistentState)
    Log.d(LOG_TAG,"savingInstanceState -----")
    if (reply_head_textView.visibility == View.VISIBLE) {
      outState.putBoolean(SIS_REPLY_VISIBILITY,true)
      outState.putString(SIS_REPLY_TEXT, reply_message_textView.text.toString())
    }

  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){

      val replyMessage = data?.getStringExtra(EXTRA_REPLY).toString()
      reply_head_textView.visibility = View.VISIBLE
      reply_message_textView.text = replyMessage
      reply_message_textView.visibility = View.VISIBLE
    }

  }

}