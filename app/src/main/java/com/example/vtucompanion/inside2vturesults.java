package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inside2vturesults extends AppCompatActivity {
    private TextView welcome2;
    private Button prevvtu;
    private Button vtu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside2vturesults);
        welcome2 =findViewById(R.id.textView152);
        prevvtu = findViewById(R.id.vtu4u);
        vtu = findViewById(R.id.resultvtu);
        welcome2.setText(" Hello "+MainActivity.forinsider+" hope you are having ");

        prevvtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.vtu4u.com/");
            }
        });
        vtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://results.vtu.ac.in/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri A = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,A));
    }
}