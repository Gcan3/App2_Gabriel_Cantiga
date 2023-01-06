package com.example.assessment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the top action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();
        setContentView(R.layout.activity_splash_screen)

        //Getting the animations from the animation resource and storing them inside a variable
        val topanim = AnimationUtils.loadAnimation(this, R.anim.anim)
        val botanim = AnimationUtils.loadAnimation(this, R.anim.bottomanim)
        //Implementing the animation variables to the text views for translation effects
        title_splash.startAnimation(topanim)
        slogan.startAnimation(botanim)
        //In a splash screen, the Handler is used to keep the screen temporarily (7 seconds)
        Handler(Looper.getMainLooper()).postDelayed({
            //The intent is used after the screen delay to move to the next page without getting back to the splash screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 7000)
    }
}