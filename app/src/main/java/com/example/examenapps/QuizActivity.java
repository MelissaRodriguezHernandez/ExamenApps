package com.example.examenapps;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class QuizActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "index";

    private Button prev, next, date;
    private TextView question, select, number, textRel;
    private EditText dateT;
    private ImageButton close;
    private ProgressBar probar;
    private RadioButton rB;
    private EditText fecha;
    private int mYear, mMonth, mDay, mHour, mMinute;


    RadioGroup radio;

    private Question[] questions = new Question[]{
        new Question(R.string.num1, R.string.question1, R.string.qSelect ),
            new Question(R.string.num2, R.string.question2, R.string.qSelect1),
            new Question(R.string.num3, R.string.question3, R.string.qSelect2),
            new Question(R.string.num4, R.string.question4,  R.string.qSelect),
    };

    int currentIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        loadFragment(new pregunta1());

        textRel = findViewById(R.id.resultado);

        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        probar = findViewById(R.id.progressBar);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        number = findViewById(R.id.numberPage);
        int numb = questions[currentIndex].getNumQ();
        number.setText(numb);


        question = findViewById(R.id.textQuestion);
        int questionQ = questions[currentIndex].getQuestionQ();
        question.setText(questionQ);

        select = findViewById(R.id.textSelect);
        int selectQ = questions[currentIndex].getqSelectQ();
        select.setText(selectQ);

        prev = findViewById(R.id.bPrevious);
        if(currentIndex == 0){
            prev.setVisibility(View.INVISIBLE);
        }
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex == 0){
                    prev.setVisibility(View.INVISIBLE);
                }
                currentIndex --;

                if(currentIndex == 2){
                    date = findViewById(R.id.btn_date);
                    dateT = findViewById(R.id.in_date);

                    //date();
                }

                updateFragment();
                updateQuestion();

            }
        });

        next = findViewById(R.id.bNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex ++;
                if(currentIndex == 2){
                    Log.e("snf", "pasa");
                    date = findViewById(R.id.btn_date);
                    dateT = findViewById(R.id.in_date);
                    //date();
                }
                if(currentIndex>0){
                    prev.setVisibility(View.VISIBLE);
                }if(currentIndex == 4){
                    next.setVisibility(View.INVISIBLE);
                    question.setVisibility(View.INVISIBLE);
                    select.setVisibility(View.INVISIBLE);
                    number.setVisibility(View.INVISIBLE);
                    probar.setVisibility(View.INVISIBLE);

                }

                updateFragment();
               updateQuestion();
            }
        });

    }

    public void updateQuestion(){

        int numberQ = questions[currentIndex].getNumQ();
        number.setText(numberQ);

        int questionQ = questions[currentIndex].getQuestionQ();
        question.setText(questionQ);

        int selectQ = questions[currentIndex].getqSelectQ();
        select.setText(selectQ);
    }

    private void loadFragment(Fragment fragment){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Quiz, fragment);
        transaction.commit();

    }

    public void updateFragment(){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transacion = fm.beginTransaction();
        if(currentIndex == 0){
            loadFragment(new pregunta1());
            probar.setProgress(1);


        }if(currentIndex == 1){

            loadFragment(new pregunta2());
            probar.setProgress(2);
        }
        if(currentIndex == 2){
            loadFragment(new pregunta3());
            probar.setProgress(3);

        }
        if(currentIndex == 3){
            loadFragment(new pregunta4());
            transacion.commit();
            probar.setProgress(4);
        }
        if(currentIndex == 4){
            loadFragment(new resultado());
            transacion.commit();
        }
    }

    public void date(){
        Log.e("4nf", "pasa");
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == date) {
                    Log.e("sn5f", "pasa");
                    // Get Current Date
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(QuizActivity.this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    dateT.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }

            }

        });
    }

}
