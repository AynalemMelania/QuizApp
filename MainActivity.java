package com.example.android.literatureapp;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score;
    EditText edit_text_question1;
    RadioGroup radioGroupQuestion2;
    RadioGroup radioGroupQuestion3;
    EditText editTextQuestion4;
    CheckBox checkBoxQuestion51;
    CheckBox checkBoxQuestion52;
    CheckBox checkBoxQuestion53;
    CheckBox checkBoxQuestion54;
    RadioGroup radioGroupQuestion6;
    Button submitButton;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.score = 0;

        edit_text_question1 = (EditText) findViewById(R.id.edit_text_question1);
        editTextQuestion4 = (EditText) findViewById(R.id.edit_text_question4);
        checkBoxQuestion51 = (CheckBox)  findViewById(R.id.answer51);
        checkBoxQuestion52 = (CheckBox)  findViewById(R.id.answer52);
        checkBoxQuestion53 = (CheckBox)  findViewById(R.id.answer53);
        checkBoxQuestion54 = (CheckBox)  findViewById(R.id.answer54);

        radioGroupQuestion2 = (RadioGroup) findViewById(R.id.radio_group_question2);
        radioGroupQuestion2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.answer21) {
                   score++;}

            }
        });

        radioGroupQuestion3 = (RadioGroup) findViewById(R.id.radio_group_question3);
        radioGroupQuestion3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.answer32) {
                    score++;
            }
        }});


        radioGroupQuestion6 = (RadioGroup) findViewById(R.id.radio_group_question6);
        radioGroupQuestion6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.answer61) {
                    score++;}

            }
        });

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                 if (edit_text_question1.getText().toString().equals("Romeo"))
                                                     score++;

                                                     if (checkBoxQuestion52.isChecked() && checkBoxQuestion54.isChecked() && !checkBoxQuestion51.isChecked() && !checkBoxQuestion53.isChecked())
                                                         score++;
                                                     String answerQuestion4 = editTextQuestion4.getText().toString();
                                                     if (answerQuestion4.equals("Dostoievski") || answerQuestion4.equals("Feodor Dostoievski") ||
                                                             answerQuestion4.equals("FM. Dostoievski") || answerQuestion4.equals("Feodor Mihailovici Dostoievski")) {
                                                         score++;
                                                     }
                                                     Toast.makeText(getApplicationContext(), "You obtained " + score + " from 6", Toast.LENGTH_SHORT).show();
                                                     submitButton.setVisibility(View.GONE);
                                                     restartButton.setVisibility(View.VISIBLE);

                                            }
                                        }
        );

        restartButton = (Button) findViewById(R.id.restart_button);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);}});
    }

}