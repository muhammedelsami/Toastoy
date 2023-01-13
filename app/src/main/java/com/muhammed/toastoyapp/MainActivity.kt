package com.muhammed.toastoyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammed.toastoy.Toastoy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // status bar color
        window.statusBarColor = getColor(R.color.bar_color)
        // navigation bar color
        window.navigationBarColor = getColor(R.color.bar_color)

        Toastoy.showDefaultToast(this,"this is a default toast")

        // go to the HomeFragment when the button is clicked
        supportFragmentManager.beginTransaction()
             .replace(R.id.fragment_container, HomeFragment())
             .commit()
    }
}