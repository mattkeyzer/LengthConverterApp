package com.example.lengthconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertNum = findViewById<EditText>(R.id.txtConvertNumber)
        val rbDolToEuR = findViewById<RadioButton>(R.id.txtradioButton1)
        val rbEuRToDol = findViewById<RadioButton>(R.id.radioButton2)
        val txtResult = findViewById<TextView>(R.id.txtButtonConvert)
        val convertIt = findViewById<Button>(R.id.txtbutton)

        convertIt.setOnClickListener{
            val tenth = DecimalFormat("#.#")
            var dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 0.92
            var convertMeasureNum: Double?

            if (rbDolToEuR.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " Euros"

                } else {
                    Toast.makeText(this@MainActivity, "Amount must be less than $10,000.",Toast.LENGTH_LONG).show()
                }

            }
            if (rbEuRToDol.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " Dollars"

                } else {
                    Toast.makeText(this@MainActivity, "Amount must be less than $10,000.",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}