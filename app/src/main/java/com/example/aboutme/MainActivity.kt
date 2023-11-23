package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
    }

    private fun initViews() {
        binding?.doneButton?.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {
        binding?.let {
            it.apply {
                nicknameText.text = nicknameEdit.text
                nicknameEdit.visibility = View.GONE
                view.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }
        }

        //Hide the keyboard
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}