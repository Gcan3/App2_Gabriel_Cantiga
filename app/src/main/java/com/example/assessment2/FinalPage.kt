package com.example.assessment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_final_page.*

class FinalPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the top action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();
        setContentView(R.layout.activity_final_page)

        //Receive the intent
        val intent = intent
        //Get the intent's passed data and store it
        //Convert to string first
        val cardNum = intent.getStringExtra("cardNumber").toString()
        val bankName = intent.getStringExtra("Bank").toString()
        val cardType = intent.getStringExtra("CardType").toString()
        //Display those received intent data
        bank_name_display.text = bankName
        card_num_display.text = cardNum
        card_type_display.text = cardType
    }
}