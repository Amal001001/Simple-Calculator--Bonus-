package com.example.simplecalculatorbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var tv:TextView
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv = findViewById(R.id.tv)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        val num1 = et1.text
        val num2 = et2.text

            button1.setOnClickListener { hideKeyboard()
                sum() }
            button2.setOnClickListener { hideKeyboard()
                sub() }
            button3.setOnClickListener { hideKeyboard()
                multiply() }
            button4.setOnClickListener { hideKeyboard()
                divide() }

    }

    fun sum(){
        if(et1.text.toString() != "" && et2.text.toString() != "")
        tv.text = "= ${et1.text.toString().toFloat() + et2.text.toString().toFloat()}"
    }
    fun sub(){
        if(et1.text.toString() != "" && et2.text.toString() != "")
        tv.text = "= ${et1.text.toString().toFloat() - et2.text.toString().toFloat()}"
    }
    fun multiply(){
        if(et1.text.toString() != "" && et2.text.toString() != "")
        tv.text = "= ${et1.text.toString().toFloat() * et2.text.toString().toFloat()}"
    }
    fun divide(){
        if(et1.text.toString() != "" && et2.text.toString() != "")
        if (et2.text.toString().toFloat() != 0.0f)
            tv.text = "= ${et1.text.toString().toFloat() / et2.text.toString().toFloat()}"
        else{tv.text =""
            Toast.makeText(this@MainActivity,"can't divide by zero",Toast.LENGTH_SHORT).show()}
    }
    fun hideKeyboard(){
        val imm = ContextCompat.getSystemService(this, InputMethodManager::class.java)
        imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
}