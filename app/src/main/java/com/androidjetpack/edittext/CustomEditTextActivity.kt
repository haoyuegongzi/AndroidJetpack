package com.androidjetpack.edittext

import android.os.Bundle
import android.widget.Toast
import com.androidjetpack.BaseActivity
import com.androidjetpack.R
import kotlinx.android.synthetic.main.activity_custom_edit_text.*

class CustomEditTextActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_edit_text)


        edit_1.setOnEditCompleteListener(object : ZEditText.OnEditCompleteListener {
            override fun onEditComplete(text: String) {
                Toast.makeText(mActivity, "edit_1 text: $text", Toast.LENGTH_SHORT).show()
            }

        })

        edit_2.setOnEditCompleteListener(object : ZEditText.OnEditCompleteListener {
            override fun onEditComplete(text: String) {
                Toast.makeText(mActivity, "edit_2 text: $text", Toast.LENGTH_SHORT).show()
            }

        })

        edit_3.setOnEditCompleteListener(object : ZEditText.OnEditCompleteListener {
            override fun onEditComplete(text: String) {
                Toast.makeText(mActivity, "edit_3 text: $text", Toast.LENGTH_SHORT).show()
            }

        })

    }
}