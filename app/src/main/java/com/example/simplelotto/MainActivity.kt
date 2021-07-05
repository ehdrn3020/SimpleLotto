package com.example.simplelotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val clearButton : Button by lazy {
        findViewById<Button>(R.id.btn_clear)
    }
    private val addButton : Button by lazy {
        findViewById<Button>(R.id.btn_add)
    }
    private val runButton: Button by lazy {
        findViewById<Button>(R.id.btn_run)
    }
    private val numberPicker : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numPicker)
    }

    private val numberTextViewList : List<TextView> by lazy {
        listOf<TextView>(
            findViewById<TextView>(R.id.txt_1),
            findViewById<TextView>(R.id.txt_2),
            findViewById<TextView>(R.id.txt_3),
            findViewById<TextView>(R.id.txt_4),
            findViewById<TextView>(R.id.txt_5),
            findViewById<TextView>(R.id.txt_6)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}