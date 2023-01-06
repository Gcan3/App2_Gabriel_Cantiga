package com.example.assessment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class signUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the top action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();
        setContentView(R.layout.activity_sign_up)

        //Register button listener
        registerbtn.setOnClickListener {
            //When the user does not provide any username
            if (newUsername.text.toString().trim().isEmpty() or newUsername.text.toString().trim().isBlank())
            {
                //Display a toast message notifying the user that it needs input
                Toast.makeText(applicationContext, "Please enter username", Toast.LENGTH_SHORT).show()
            }
            //Same case for when the password input is empty/blank
            else if (newPassword.text.toString().trim().isEmpty() or newPassword.text.toString().trim().isBlank())
            {
                //Display a toast message notifying the user that it needs input
                Toast.makeText(applicationContext, "Please enter password", Toast.LENGTH_SHORT).show()
            }
            //Executes when there are inputs
            else
            {
                //Storing the inputs into a variable
                //Convert to text and to string first
                val user = newUsername.text.toString()
                val pass = newPassword.text.toString()
                //Make an intent variable
                val intent = Intent(this@signUp, SignIn::class.java)
                //Using putExtra on the input data to include it with the intent variable
                intent.putExtra("RegisteredUsername", user)
                intent.putExtra("RegisteredPassword", pass)
                //flags is to start an activity (as a new one) on intent so that the user cannot go back and cause error
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                //start the intent
                startActivity(intent)
            }
        }
    }
}