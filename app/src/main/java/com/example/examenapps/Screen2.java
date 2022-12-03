package com.example.examenapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Screen2 extends AppCompatActivity {

    Button sign1, continu1;
    TextInputEditText textInput;
    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> contras = new ArrayList<>();
    static String email;
    static Boolean newGuest = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sign1 = findViewById(R.id.sign2);
        continu1 = findViewById(R.id.bConitue2);

        textInput = findViewById(R.id.textInputEmail);

        if(textInput.isTextInputLayoutFocusedRectEnabled()){
            sign1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    newGuest = true;
                    Intent intent2 = new Intent(Screen2.this, Screen3.class);
                    startActivity(intent2);
                }
            });

            continu1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(comprobarEmail(textInput.getText().toString())){
                        email = textInput.getText().toString();
                        Intent intent1 = new Intent(Screen2.this, Screen3.class);
                        startActivity(intent1);
                    }else{
                        Toast.makeText(getApplicationContext(), "El email no existe", Toast.LENGTH_SHORT).show();
                        textInput.setText(null);
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
        return existe;
    }

}
