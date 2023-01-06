package com.example.assessment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding the top action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();
        setContentView(R.layout.activity_main_page)

        //Call in the modal view which displays texts
        //One of the texts comes from the strings.xml resource
        val modalFragment = ModalFragment()
        //Show the modal view using the supportFragmentManager
        modalFragment.show(supportFragmentManager, "BottomDialog")

        //Make a spinner variable
        val bankspin: Spinner = bankSpinner
        //Use createFromResource to get the specific stored array of strings
        //Link the array to the spinner
        ArrayAdapter.createFromResource(this, R.array.bank_array, android.R.layout.simple_spinner_item
        )
            //Get the simple spinner drop down list from the layout resources
            .also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //Link the spinner to the adapter
            bankspin.adapter = adapter
        }
        //Setting up two buttons that perform a similar function on click
        //Both will use intent to go to the next page
        //They will also pass a stored data along with the intent using putExtra
        //These data include a selected position of the bank spinner
        //The difference between the two buttons is the card type value that will be passed
        currentbtn.setOnClickListener {
            val cardnum = cardNumberInput.text.toString()
            val bankname = bankSpinner.selectedItem.toString()
            val current = "Current"
            val goFinal = Intent(this@MainPage, FinalPage::class.java)
            goFinal.putExtra("cardNumber", cardnum)
            goFinal.putExtra("Bank", bankname)
            goFinal.putExtra("CardType", current)
            //flags is used to go to the next page and treat it as a new activity
            //In other words, the user cannot go back and cause some errors
            goFinal.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(goFinal)
        }
        savingsbtn.setOnClickListener {
            val cardnum = cardNumberInput.text.toString()
            val bankname = bankSpinner.selectedItem.toString()
            val saving = "Savings"
            val goFinal = Intent(this@MainPage, FinalPage::class.java)
            goFinal.putExtra("cardNumber", cardnum)
            goFinal.putExtra("Bank", bankname)
            goFinal.putExtra("CardType", saving)
            //flags is used to go to the next page and treat it as a new activity
            //In other words, the user cannot go back and cause some errors
            goFinal.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(goFinal)
        }
    }

}