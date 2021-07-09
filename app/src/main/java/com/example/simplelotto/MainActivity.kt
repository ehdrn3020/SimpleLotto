package com.example.simplelotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val clearButton : Button by lazy {
        findViewById<Button>(R.id.btn_clear)
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
    private var didRun = false
    private val pickNumberSet = hashSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        //Auto Number Picker
        initRunButton()
        ininClearButton()
    }

    private fun initRunButton() {
        runButton.setOnClickListener{
            val list = getRandomNumber()
            //if clear random number or not
            didRun = true
            list.forEachIndexed{index,number->
                val textView = numberTextViewList[index]
                textView.text = number.toString()
                textView.isVisible = true
            }
            Log.d("MainActivity", list.toString())
        }
    }

    private fun getRandomNumber():List<Int> {
        val nummberList = mutableListOf<Int>().apply {
            for(i in 1..45){
                if (pickNumberSet.contains(i)){
                    continue
                }
                this.add(i)
            }
        }
        nummberList.shuffle()
        val newList = pickNumberSet.toList()+nummberList.subList(0,6-pickNumberSet.size)
        return newList.sorted()
    }

    private fun ininClearButton() {
        clearButton.setOnClickListener{
            pickNumberSet.clear()
            numberTextViewList.forEach{
                it.isVisible = false
            }
            val textView = numberTextViewList[0]
            textView.text = "0"
            textView.isVisible = true
            didRun = false
        }

    }

}