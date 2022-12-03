package com.example.examenapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Screen3 extends AppCompatActivity {

    Button  sign;
    ImageButton back;
    TextInputEditText emailI, contraI;
    String TAG = "DCSD";

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        emailI = findViewById(R.id.EmailI);
        contraI = findViewById(R.id.ContraI);

        back = findViewById(R.id.bBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen3.this, Screen2.class);
                startActivity(intent);
            }
        });



        sign = findViewById(R.id.bSignIn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Screen2.newGuest.toString().equals("true")){
                    Screen2.emails.add(emailI.getText().toString());
                    Screen2.contras.add(contraI.getText().toString());
                    Intent intent = new Intent(Screen3.this, QuizActivity.class);
                    startActivity(intent);
                }else{
                    if(String.valueOf(comprobarContra()).equals("false")){
                        Intent intent = new Intent(Screen3.this, Screen2.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Screen3.this, QuizActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });


    }

    public boolean comprobarContra(){
        boolean correcto = false;

        for (int i = 0; i < Screen2.emails.size(); i++) {
            if(Screen2.emails.get(i).equals(emailI)){
                if(Screen2.contras.get(i).equals(contraI)){
                    correcto = true;
                }
            }
        }

        return correcto;
    }
}
