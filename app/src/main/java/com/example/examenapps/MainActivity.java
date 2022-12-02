package com.example.examenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sign, continu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = findViewById(R.id.bSign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiar(view);
            }
        });

        continu = findViewById(R.id.bConitue);
        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiar(view);
            }
        });
    }

    public void cambiar(View view){
        Intent intent = new Intent(MainActivity.this, Screen2.class);
        startActivity(intent);
    }



}