package com.example.genpass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.genpass.R
import android.annotation.SuppressLint
import android.widget.EditText
import android.content.ClipData
import android.content.ClipboardManager
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun clc(view: View?) {
        val btn = findViewById<View>(R.id.button) as Button
        val tv = findViewById<View>(R.id.editTextTextMultiLine) as EditText
        val size = findViewById<View>(R.id.editTextNumber) as EditText
        val swt_1 = findViewById<View>(R.id.switch2) as Switch
        val swt_2 = findViewById<View>(R.id.switch3) as Switch
        val rand = Random()
        val special_Symbols = "~!@#$%^&*()_-+={}[]\\|:;\"<>,.?/"
        val english_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
        val number = "1234567890"
        val arr_1: Array<String?>
        val arr_2: Array<String?>

        /*Validating input line size*/if (size.text.toString() == "") {
            val rand_2 = rand.nextInt(100)
            val rand_2_str = Integer.toString(rand_2)
            size.setText(rand_2_str)
        } else {
            if (swt_1.isChecked && swt_2.isChecked) {
//
                val size_str = size.text.toString()
                var size_int = size_str.toInt()
                arr_1 = arrayOfNulls(size_int)
                var i = 0
                val size_index = size_int - 1
                arr_2 = arrayOfNulls(size_int)
                while (size_int >= 0 && i <= size_index) {
                    val random_symbol = rand.nextInt(30)
                    val random_letter = rand.nextInt(52)
                    val random_num = rand.nextInt(10)
                    val char_symbol = special_Symbols[random_symbol]
                    val char_letter = english_alphabet[random_letter]
                    val char_num = number[random_num]
                    val symbol_str = char_symbol.toString()
                    val letter_str = char_letter.toString()
                    val num_str = char_num.toString()
                    val Combination = rand.nextInt(3)
                    println("Test: $Combination")
                    if (Combination == 0) {
                        println("Test is equals 0")
                        arr_1[i] = symbol_str + letter_str + num_str
                    } else if (Combination == 1) {
                        println("Test is equals 1")
                        arr_1[i] = num_str + letter_str + symbol_str
                    } else if (Combination == 2) {
                        println("Test is equals 2")
                        arr_1[i] = letter_str + num_str + symbol_str
                    }
                    i = i + 1
                    size_int -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                    print(arr_2[s])
                }
                val str = java.lang.String.join("", *arr_2)
                println()
                println(str)
                tv.setText(str)
                /*Copy in clipboard*/
                val clip: ClipboardManager
                clip = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData
                myData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else if (swt_1.isChecked) {
                val size_str = size.text.toString()
                var size_int = size_str.toInt()
                arr_1 = arrayOfNulls(size_int)
                var i = 0
                val size_index = size_int - 1
                arr_2 = arrayOfNulls(size_int)
                while (size_int >= 0 && i <= size_index) {
                    val random_symbol = rand.nextInt(30)
                    val random_letter = rand.nextInt(52)
                    val char_symbol = special_Symbols[random_symbol]
                    val char_letter = english_alphabet[random_letter]
                    val symbol_str = char_symbol.toString()
                    val letter_str = char_letter.toString()
                    val Combination = rand.nextInt(2)
                    if (Combination == 0) {
                        println("Test is equals 0")
                        arr_1[i] = symbol_str + letter_str
                    } else if (Combination == 1) {
                        println("Test is equals 1")
                        arr_1[i] = letter_str + symbol_str
                    }
                    i = i + 1
                    size_int -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                    print(arr_2[s])
                }
                val str = java.lang.String.join("", *arr_2)
                tv.setText(str)
                val clip: ClipboardManager
                clip = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData
                myData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else if (swt_2.isChecked) {
                val size_str = size.text.toString()
                var size_int = size_str.toInt()
                arr_1 = arrayOfNulls(size_int)
                var i = 0
                val size_index = size_int - 1
                arr_2 = arrayOfNulls(size_int)
                while (size_int >= 0 && i <= size_index) {
                    val random_letter = rand.nextInt(52)
                    val random_num = rand.nextInt(10)
                    val char_letter = english_alphabet[random_letter]
                    val char_num = number[random_num]
                    val letter_str = char_letter.toString()
                    val num_str = char_num.toString()
                    val Combination = rand.nextInt(2)
                    if (Combination == 0) {
                        println("Test is equals 0")
                        arr_1[i] = letter_str + num_str
                    } else if (Combination == 1) {
                        println("Test is equals 1")
                        arr_1[i] = num_str + letter_str
                    }
                    i = i + 1
                    size_int -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                    print(arr_2[s])
                }
                val str = java.lang.String.join("", *arr_2)
                tv.setText(str)
                val clip: ClipboardManager
                clip = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData
                myData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else {
                val size_str = size.text.toString()
                var size_int = size_str.toInt()
                arr_1 = arrayOfNulls(size_int)
                var i = 0
                val size_index = size_int - 1
                arr_2 = arrayOfNulls(size_int)
                while (size_int >= 0 && i <= size_index) {
                    val random_letter = rand.nextInt(52)
                    val char_letter = english_alphabet[random_letter]
                    val letter_str = char_letter.toString()
                    arr_1[i] = letter_str
                    i = i + 1
                    size_int -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                    print(arr_2[s])
                }
                val str = java.lang.String.join("", *arr_2)
                println()
                println(str)
                tv.setText(str)
                /*Copy in clipboard*/
                val clip: ClipboardManager
                clip = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData
                myData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            }
            //
        }
    }
}