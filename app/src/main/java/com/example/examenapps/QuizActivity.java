package com.example.examenapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    Button prev, next;
    TextView question, select, number;
    LinearLayout quiz;

    private Question[] questions = new Question[]{
        new Question(1, R.string.question1, R.string.qSelect ),
            new Question(2, R.string.question2, R.string.qSelect1),
            new Question(3, R.string.question3, R.string.qSelect2),
            new Question(4, R.string.question4,  R.string.qSelect),
    };

    ArrayList<String> pregunta1 = new ArrayList<>();
    ArrayList<String> pregunta2 = new ArrayList<>();


    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        pregunta1.add("Read");
        pregunta1.add("Work out");
        pregunta1.add("Draw");
        pregunta1.add("Play video");

        quiz = findViewById(R.id.Quiz);

        number = findViewById(R.id.numberPage);
        int numberQ = questions[currentIndex].getNumQ();
        number.setText(numberQ);

        question = findViewById(R.id.textQuestion);
        int questionQ = questions[currentIndex].getQuestion();
        question.setText(questionQ);

        select = findViewById(R.id.textSelect);
        int selectQ = questions[currentIndex].getqSelect();
        select.setText(selectQ);

        prev = findViewById(R.id.bPrevious);
        if(currentIndex == 0){
            prev.setVisibility(View.INVISIBLE);
        }
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        next = findViewById(R.id.bNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex ++;

               updateQuestion();
            }
        });

    }

    public void updateQuestion(){
        int numberQ = questions[currentIndex].getNumQ();
        number.setText(numberQ);

        int questionQ = questions[currentIndex].getQuestion();
        question.setText(questionQ);

        int selectQ = questions[currentIndex].getqSelect();
        select.setText(selectQ);
    }



}
