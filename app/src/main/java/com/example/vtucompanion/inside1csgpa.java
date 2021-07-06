package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inside1csgpa extends AppCompatActivity {
    private Button cgpa;
    private Button sgpa;
    private TextView welcome1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside1csgpa);
        cgpa = findViewById(R.id.vtu4u);
        sgpa = findViewById(R.id.resultvtu);
        welcome1 =findViewById(R.id.textView152);
        welcome1.setText(" Hello "+MainActivity.forinsider+" hope you are having ");

        cgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(inside1csgpa.this,cgpaprog.class));
            }
        });
        sgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inside1csgpa.this,sgpaprog.class));
            }
        });
    }
}