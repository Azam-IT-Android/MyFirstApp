package com.ismail.creatvt.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.constraint_demo.*
import pl.kremblewski.expressionevaluator.evaluate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_demo)

        var numbersMap = hashMapOf<Button, String>(
                number_1 to "1",
                number_2 to "2",
                number_3 to "3",
                number_4 to "4",
                number_5 to "5",
                number_6 to "6",
                number_7 to "7",
                number_8 to "8",
                number_9 to "9",
                number_0 to "0"
        )

        var operatorsMap = hashMapOf(
                multiplication to '✕',
                division to '%',
                addition to '+',
                subtraction to '-'
        )

        for ((button, value) in numbersMap) {
            button.setOnClickListener {
                val text = output_text.text.toString()
                output_text.text = text + value
            }
        }

        for ((button, value) in operatorsMap) {
            button.setOnClickListener {
                var text = output_text.text.toString()

                if(text.isNotEmpty()){
                    // Get the last character
                    val lastValue = text.last()

                    // Check if it's an operator
                    if(operatorsMap.containsValue(lastValue)){
                        text = text.substring(0, text.length - 1)
                    }
                    output_text.text = text + value
                } else if(value == '-'){
                    output_text.text = text + value
                }
            }
        }

        backspace.setOnClickListener {
            val text = output_text.text.toString()
            // Only remove last character if the text is not empty
            if (text.isNotEmpty()) {
                output_text.text = text.substring(0, text.length - 1)
            }
        }

        equals.setOnClickListener {
            val text = output_text.text.toString().replace('✕', '*')
            val answer = evaluate(text)
            output_text.text = answer.toString()
        }
    }

}