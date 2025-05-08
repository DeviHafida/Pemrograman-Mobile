package com.example.tipcalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculation.R
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var costOfService: EditText
    private lateinit var tipOptions: Spinner
    private lateinit var roundUpSwitch: Switch
    private lateinit var tipResult: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi view dari layout
        costOfService = findViewById(R.id.cost_of_service)
        tipOptions = findViewById(R.id.tip_options)
        roundUpSwitch = findViewById(R.id.round_up_switch)
        tipResult = findViewById(R.id.tip_result)
        calculateButton = findViewById(R.id.calculate_button)

        // Set data ke Spinner
        val tipPercentages = arrayOf("15%", "18%", "20%")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipPercentages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tipOptions.adapter = adapter

        // Handle button click
        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val costInput = costOfService.text.toString()
        val cost = costInput.toDoubleOrNull()

        // Validasi input
        if (cost == null || cost <= 0) {
            tipResult.text = "Masukkan nominal yang valid"
            return
        }

        // Ambil persentase tip dari pilihan spinner
        val tipPercentage = when (tipOptions.selectedItem.toString()) {
            "20%" -> 0.20
            "18%" -> 0.18
            "15%" -> 0.15
            else -> 0.15 // default fallback
        }

        // Hitung tip
        var tip = cost * tipPercentage
        if (roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }

        // Tampilkan hasil
        tipResult.text = "Tip: Rp %.0f".format(tip)
    }
}

private fun Any.onCreate(savedInstanceState: Bundle?) {

}
