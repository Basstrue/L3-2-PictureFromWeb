package com.example.pictfromweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MainActivity : AppCompatActivity() {
    private lateinit var mEditText: EditText
    private lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mEditText = findViewById(R.id.editText)
        mImageView = findViewById(R.id.imageView)
    }

    fun loadImage(view: View) {
        val entered_text: String = mEditText.text.toString()
        Glide.with(this)
            .load(entered_text)
            .error(Toast.makeText(this, "Can't load a pict", Toast.LENGTH_LONG).show())
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(mImageView)

    }
}