package com.example.assessment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the top action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();
        setContentView(R.layout.activity_sign_in)

        //Setting up a variable to store the intent received
        val intent = intent
        //Using that same intent to get the passed data and getting it with getStringExtra
        //Convert the data into string before storing it in their respective variables
        val registeredUsername = intent.getStringExtra("RegisteredUsername").toString()
        val registeredPassword = intent.getStringExtra("RegisteredPassword").toString()

        //Button listener
        signInbtn.setOnClickListener{
            //Convert the user input into string before storing them inside the variables
            val username = usernameInput.text.toString()
            val userPass = passwordInput.text.toString()
            //Using if gates to check if the passed data and the user inputs are the same
            //This is to confirm the user's registered and stored data
            if ((username == registeredUsername) && (userPass == registeredPassword))
            {
                //If successful, go to the next page using intent
                val moveMainPage = Intent(this@SignIn, MainPage::class.java)
                startActivity(moveMainPage)
            }
            else
            {
                //If not successful, make the invalidity texts appear
                invalideUserText.visibility = View.VISIBLE
                invalidPassword.visibility = View.VISIBLE
            }

        }

        //Button listener if the user does not have any stored data yet
        sign_up_btn.setOnClickListener {
            //Bring the user to the sign up page using intent
            val registerIntent = Intent(this@SignIn, signUp::class.java)
            startActivity(registerIntent)
        }
    }

}