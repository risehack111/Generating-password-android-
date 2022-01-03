package com.example.genpass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.EditText
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Build
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun clc(view: View?) {
        val tv = findViewById<View>(R.id.editTextTextMultiLine) as EditText
        val size = findViewById<View>(R.id.editTextNumber) as EditText
        val switch1 = findViewById<View>(R.id.switch2) as Switch
        val switch2 = findViewById<View>(R.id.switch3) as Switch
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
            if (switch1.isChecked && switch2.isChecked) {

                val sizeStr = size.text.toString()
                var sizeInt = sizeStr.toInt()
                arr_1 = arrayOfNulls(sizeInt)
                var i = 0
                val sizeIndex = sizeInt - 1
                arr_2 = arrayOfNulls(sizeInt)
                while (sizeInt >= 0 && i <= sizeIndex) {
                    val randomSymbol = rand.nextInt(30)
                    val randomLetter = rand.nextInt(52)
                    val randomNum = rand.nextInt(10)
                    val charSymbol = special_Symbols[randomSymbol]
                    val charLetter = english_alphabet[randomLetter]
                    val charNum = number[randomNum]
                    val symbolStr = charSymbol.toString()
                    val letterStr = charLetter.toString()
                    val numStr = charNum.toString()
                    val Combination = rand.nextInt(3)

                    when (Combination) {
                        0 -> {

                            arr_1[i] = symbolStr + letterStr + numStr
                        }
                        1 -> {

                            arr_1[i] = numStr + letterStr + symbolStr
                        }
                        2 -> {

                            arr_1[i] = letterStr + numStr + symbolStr
                        }
                    }
                    i += 1
                    sizeInt -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                }
                val str = java.lang.String.join("", *arr_2)
                println()
                tv.setText(str)
                /*Copy in clipboard*/
                val clip: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else if (switch1.isChecked) {
                val sizeStr = size.text.toString()
                var sizeInt = sizeStr.toInt()
                arr_1 = arrayOfNulls(sizeInt)
                var i = 0
                val sizeIndex = sizeInt - 1
                arr_2 = arrayOfNulls(sizeInt)
                while (sizeInt >= 0 && i <= sizeIndex) {
                    val randomSymbol = rand.nextInt(30)
                    val randomLetter = rand.nextInt(52)
                    val charSymbol = special_Symbols[randomSymbol]
                    val charLetter = english_alphabet[randomLetter]
                    val symbolStr = charSymbol.toString()
                    val letterStr = charLetter.toString()
                    val Combination = rand.nextInt(2)
                    if (Combination == 0) {
                        arr_1[i] = symbolStr + letterStr
                    } else if (Combination == 1) {
                        arr_1[i] = letterStr + symbolStr
                    }
                    i += 1
                    sizeInt -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                }
                val str = java.lang.String.join("", *arr_2)
                tv.setText(str)
                val clip: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else if (switch2.isChecked) {
                val sizeStr = size.text.toString()
                var sizeInt = sizeStr.toInt()
                arr_1 = arrayOfNulls(sizeInt)
                var i = 0
                val sizeIndex = sizeInt - 1
                arr_2 = arrayOfNulls(sizeInt)
                while (sizeInt >= 0 && i <= sizeIndex) {
                    val randomLetter = rand.nextInt(52)
                    val randomNum = rand.nextInt(10)
                    val charLetter = english_alphabet[randomLetter]
                    val charNum = number[randomNum]
                    val letterStr = charLetter.toString()
                    val numStr = charNum.toString()
                    val Combination = rand.nextInt(2)
                    if (Combination == 0) {
                        arr_1[i] = letterStr + numStr
                    } else if (Combination == 1) {
                        arr_1[i] = numStr + letterStr
                    }
                    i += 1
                    sizeInt -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                }
                val str = java.lang.String.join("", *arr_2)
                tv.setText(str)
                val clip: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            } else {
                val sizeStr = size.text.toString()
                var sizeInt = sizeStr.toInt()
                arr_1 = arrayOfNulls(sizeInt)
                var i = 0
                val sizeIndex = sizeInt - 1
                arr_2 = arrayOfNulls(sizeInt)
                while (sizeInt >= 0 && i <= sizeIndex) {
                    val randomLetter = rand.nextInt(52)
                    val charLetter = english_alphabet[randomLetter]
                    val letterStr = charLetter.toString()
                    arr_1[i] = letterStr
                    i += 1
                    sizeInt -= 1
                }
                for (s in 0 until i) {
                    arr_2[s] = arr_1[s]
                }
                val str = java.lang.String.join("", *arr_2)
                println()
                tv.setText(str)
                /*Copy in clipboard*/
                val clip: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val myData: ClipData = ClipData.newPlainText("", str)
                clip.setPrimaryClip(myData)
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show()
            }
        }
    }
}