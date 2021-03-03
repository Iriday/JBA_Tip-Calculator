package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billEditText = findViewById<EditText>(R.id.edit_text)
        val tipPercentSlider = findViewById<Slider>(R.id.slider)
        val tipTextView = findViewById<TextView>(R.id.text_view)

        billEditText.addTextChangedListener {
            tipTextView.text =
                if (it.isNullOrBlank())
                    ""
                else
                    toResultStr(it.toString(), tipPercentSlider.value)
        }

        tipPercentSlider.addOnChangeListener { _, value, _ ->
            tipTextView.text =
                if (billEditText.text.isNullOrBlank())
                    ""
                else
                    toResultStr(billEditText.text.toString(), value)
        }

    }

    private fun toResultStr(bill: String, percentage: Float): String {
        return "Bill value: $bill, tip percentage: $percentage%"
    }
}