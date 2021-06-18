package com.example.genpass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public void clc(View view) {
        final Button btn = (Button) findViewById(R.id.button);
        final EditText tv = (EditText) findViewById(R.id.editTextTextMultiLine);
        EditText size = (EditText) findViewById(R.id.editTextNumber);
        final Switch swt_1 = (Switch) findViewById(R.id.switch2);
        final Switch swt_2 = (Switch) findViewById(R.id.switch3);
        Random rand = new Random();
        final String special_Symbols = "~!@#$%^&*()_-+={}[]\\|:;\"<>,.?/";
        final String english_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final String number = "1234567890";
        String[] arr_1;
        String[] arr_2;

        /*Validating input line size*/
        if(size.getText().toString().equals(""))
        {
            int rand_2 = rand.nextInt(100);
            String rand_2_str = Integer.toString(rand_2);
            size.setText(rand_2_str);
        }

        else {
            if (swt_1.isChecked() && swt_2.isChecked()) {
//
                String size_str = String.valueOf(size.getText());
                int size_int = Integer.parseInt(size_str);
                arr_1 = new String[size_int];

                int i = 0;
                int size_index = size_int - 1;
                arr_2 = new String[size_int];
                while (size_int >= 0 && i <= size_index) {
                    int random_symbol = rand.nextInt(30);
                    int random_letter = rand.nextInt(52);
                    int random_num = rand.nextInt(10);
                    char char_symbol = special_Symbols.charAt(random_symbol);
                    char char_letter = english_alphabet.charAt(random_letter);
                    char char_num = number.charAt(random_num);
                    String symbol_str = String.valueOf(char_symbol);
                    String letter_str = String.valueOf(char_letter);
                    String num_str = String.valueOf(char_num);
                    int Combination = rand.nextInt(3);
                    System.out.println("Test: " + Combination);
                    if (Combination == 0) {
                        System.out.println("Test is equals 0");
                        arr_1[i] = symbol_str + letter_str + num_str;
                    } else if (Combination == 1) {
                        System.out.println("Test is equals 1");
                        arr_1[i] = num_str + letter_str + symbol_str;
                    }
                    else if(Combination == 2)
                    {
                        System.out.println("Test is equals 2");
                        arr_1[i] = letter_str + num_str + symbol_str;
                    }

                    i = i + 1;
                    size_int -= 1;
                }
                for (int s = 0; s < i; s++) {
                    arr_2[s] = arr_1[s];
                    System.out.print(arr_2[s]);

                }
                String str = String.join("", arr_2);
                System.out.println();
                System.out.println(str);
                tv.setText(str);
                /*Copy in clipboard*/
                ClipboardManager clip;
                clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myData;
                myData = ClipData.newPlainText("", str);
                clip.setPrimaryClip(myData);
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show();
            }

            else if (swt_1.isChecked()) {
                String size_str = String.valueOf(size.getText());
                int size_int = Integer.parseInt(size_str);
                arr_1 = new String[size_int];

                int i = 0;
                int size_index = size_int - 1;
                arr_2 = new String[size_int];

                while (size_int >= 0 && i <= size_index) {
                    int random_symbol = rand.nextInt(30);
                    int random_letter = rand.nextInt(52);
                    char char_symbol = special_Symbols.charAt(random_symbol);
                    char char_letter = english_alphabet.charAt(random_letter);
                    String symbol_str = String.valueOf(char_symbol);
                    String letter_str = String.valueOf(char_letter);
                    int Combination = rand.nextInt(2);
                    if(Combination == 0){
                        System.out.println("Test is equals 0");
                        arr_1[i] = symbol_str + letter_str;
                    }
                    else if(Combination == 1)
                    {
                        System.out.println("Test is equals 1");
                        arr_1[i] = letter_str + symbol_str;
                    }

                    i = i + 1;
                    size_int -= 1;
                }
                for (int s = 0; s < i; s++) {
                    arr_2[s] = arr_1[s];
                    System.out.print(arr_2[s]);
                }
                String str = String.join("", arr_2);
                tv.setText(str);
                ClipboardManager clip;
                clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myData;
                myData = ClipData.newPlainText("", str);
                clip.setPrimaryClip(myData);
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show();
            }

            else if (swt_2.isChecked()) {
                String size_str = String.valueOf(size.getText());
                int size_int = Integer.parseInt(size_str);
                arr_1 = new String[size_int];

                int i = 0;
                int size_index = size_int - 1;
                arr_2 = new String[size_int];
                while (size_int >= 0 && i <= size_index) {
                    int random_letter = rand.nextInt(52);
                    int random_num = rand.nextInt(10);
                    char char_letter = english_alphabet.charAt(random_letter);
                    char char_num = number.charAt(random_num);
                    String letter_str = String.valueOf(char_letter);
                    String num_str = String.valueOf(char_num);
                    int Combination = rand.nextInt(2);
                    if (Combination == 0) {
                        System.out.println("Test is equals 0");
                        arr_1[i] = letter_str + num_str;
                    } else if (Combination == 1) {
                        System.out.println("Test is equals 1");
                        arr_1[i] = num_str + letter_str;
                    }

                    i = i + 1;
                    size_int -= 1;

                }
                for (int s = 0; s < i; s++) {
                    arr_2[s] = arr_1[s];
                    System.out.print(arr_2[s]);
                }

                String str = String.join("", arr_2);
                tv.setText(str);
                ClipboardManager clip;
                clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myData;
                myData = ClipData.newPlainText("", str);
                clip.setPrimaryClip(myData);
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show();
            }
            else{
                String size_str = String.valueOf(size.getText());
                int size_int = Integer.parseInt(size_str);
                arr_1 = new String[size_int];

                int i = 0;
                int size_index = size_int - 1;
                arr_2 = new String[size_int];
                while (size_int >= 0 && i <= size_index) {
                    int random_letter = rand.nextInt(52);
                    char char_letter = english_alphabet.charAt(random_letter);
                    String letter_str = String.valueOf(char_letter);
                    arr_1[i] = letter_str;
                    i = i + 1;
                    size_int -= 1;
                }
                for (int s = 0; s < i; s++) {
                    arr_2[s] = arr_1[s];
                    System.out.print(arr_2[s]);
                }
                String str = String.join("", arr_2);
                System.out.println();
                System.out.println(str);
                tv.setText(str);
                /*Copy in clipboard*/
                ClipboardManager clip;
                clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myData;
                myData = ClipData.newPlainText("", str);
                clip.setPrimaryClip(myData);
                Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_LONG).show();
            }
//
        }
    }
}