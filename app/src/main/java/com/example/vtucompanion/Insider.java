package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Insider extends AppCompatActivity {
        private TextView welcome;
        private Button csgpa;
        private Button vturesult;
        private Button Todo;
        private Button StudyMls;
        private Button pro;
        private Button feedbck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insider);

        welcome = findViewById(R.id.textView152);
        csgpa = findViewById(R.id.button3);
        vturesult = findViewById(R.id.button8);
        Todo = findViewById(R.id.button9);
        StudyMls = findViewById(R.id.button12);
        pro = findViewById(R.id.button10);
        feedbck = findViewById(R.id.button_feedback);

        StudyMls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(Insider.this,insideStudyMaterials.class));
            }
        });
        Todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Insider.this,TodoLists.class));
            }
        });
        csgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Insider.this,inside1csgpa.class));
            }
        });

        vturesult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Insider.this,inside2vturesults.class));
            }
        });
        welcome.setText(" Hello "+MainActivity.forinsider+" hope you are having ");

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Insider.this,Profile.class));
            }
        });
    feedbck.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Insider.this,feedBackSystem.class));
        }
    });
    }

}