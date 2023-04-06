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
        val rbInToCm = findViewById<RadioButton>(R.id.txtradioButton1)
        val rbCmToIn = findViewById<RadioButton>(R.id.radioButton2)
        val txtResult = findViewById<TextView>(R.id.txtButtonConvert)
        val convertIt = findViewById<Button>(R.id.txtbutton)

        convertIt.setOnClickListener{
            val tenth = DecimalFormat("#.#")
            var dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 2.54
            var convertMeasureNum: Double?

            if (rbInToCm.isChecked) {
                if (dblMeasure <= 72) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " cm"

                } else {
                    Toast.makeText(this@MainActivity, "Inches must be less than 72.",Toast.LENGTH_LONG).show()
                }

            }
            if (rbCmToIn.isChecked) {
                if (dblMeasure <= 185) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " in"

                } else {
                    Toast.makeText(this@MainActivity, "Centimeters must be less than 185.",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}