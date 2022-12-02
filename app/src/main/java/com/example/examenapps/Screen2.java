package com.example.examenapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Screen2 extends AppCompatActivity {

    Button sign, continu;
    TextInputEditText textInput;
    static ArrayList<String> emails;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sign = findViewById(R.id.bSign);
        continu = findViewById(R.id.bConitue);

        textInput = findViewById(R.id.textInputEmail);

        if(textInput.isTextInputLayoutFocusedRectEnabled()){
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cambiar(view);
                }
            });

            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(comprobarEmail(textInput.getText().toString())){
                        cambiar(view);
                    }
                    if(!comprobarEmail(textInput.getText().toString())){
                        emails.add(textInput.getText().toString());

                    }
                }
            });
        }

    }

    public boolean comprobarEmail(String email){
        boolean existe = false;

        for (int i = 0; i < emails.size(); i++) {
            if(emails.get(i).equals(email)){
                existe = true;
            }
        }

        System.out.println(existe);
        System.out.println(emails.toString());

        return existe;
    }

    public void cambiar(View view){
        Intent intent = new Intent(Screen2.this, Screen3.class);
        startActivity(intent);
    }

}
