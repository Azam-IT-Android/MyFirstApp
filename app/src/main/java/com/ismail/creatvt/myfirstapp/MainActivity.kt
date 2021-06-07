package com.ismail.creatvt.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.constraint_demo.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_demo)

        var buttonsMap = hashMapOf<Button, String>(
            number_1 to "1",
            number_2 to "2",
            number_3 to "3",
            number_4 to "4",
            number_5 to "5",
            number_6 to "6",
            number_7 to "7",
            number_8 to "8",
            number_9 to "9",
            number_0 to "0",
            multiplication to "x",
            division to "%",
            addition to "+",
            subtraction to "-",
        )

        for((button, value) in buttonsMap){
            button.setOnClickListener {
                val text = output_text.text.toString()
                output_text.text = text + value
            }
        }

        backspace.setOnClickListener {
            val text = output_text.text.toString()
            // Only remove last character if the text is not empty
            if(text.isNotEmpty()){
                output_text.text = text.substring(0, text.length - 1)
            }
        }
    }

}