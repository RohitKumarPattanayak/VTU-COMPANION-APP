package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sgpaprog extends AppCompatActivity {
    private TextView semester;
    private TextView sub1;
    private TextView sub2;
    private TextView sub3;
    private TextView sub4;
    private TextView sub5;
    private TextView sub6;
    private TextView sub7;
    private TextView sub8;
    private TextView sub9;
    private TextView Result;
    private Button submit;
    private Button calculate;
    private Button clear;
    private TextView val1;
    private TextView val2;
    private TextView val3;
    private TextView val4;
    private TextView val5;
    private TextView val6;
    private TextView val7;
    private TextView val8;
    private TextView val9;
    private int v1 = 0;
    private int v2 = 0;
    private int v3 = 0;
    private int v4 = 0;
    private int v5 = 0;
    private int v6 = 0;
    private int v7 = 0;
    private int v8 = 0;
    private int v9 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpaprog);
        semester = findViewById(R.id.editTextTextPersonName12);
        sub1 = findViewById(R.id.textView27);
        sub2 = findViewById(R.id.textView35);
        sub3 = findViewById(R.id.textView34);
        sub4 = findViewById(R.id.textView33);
        sub5 = findViewById(R.id.textView32);
        sub6 = findViewById(R.id.textView28);
        sub7 = findViewById(R.id.textView36);
        sub8 = findViewById(R.id.textView37);
        sub9 = findViewById(R.id.textView15);
        Result = findViewById(R.id.textView47);
        val1= findViewById(R.id.editTextTextPersonName2);
        val2= findViewById(R.id.editTextTextPersonName3);
        val3= findViewById(R.id.editTextTextPersonName5);
        val4= findViewById(R.id.editTextTextPersonName4);
        val5= findViewById(R.id.editTextTextPersonName6);
        val6= findViewById(R.id.editTextTextPersonName7);
        val7= findViewById(R.id.editTextTextPersonName9);
        val8= findViewById(R.id.editTextTextPersonName10);
        val9= findViewById(R.id.editTextTextPersonName13);
        submit = findViewById(R.id.button5);
        calculate = findViewById(R.id.button7);
        clear = findViewById(R.id.button13);
        String s1 = semester.getText().toString();;


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1.setText(null);
                val2.setText(null);
                val3.setText(null);
                val4.setText(null);
                val5.setText(null);
                val6.setText(null);
                val7.setText(null);
                val8.setText(null);
                val9.setText(null);
                Result.setText(null);
                semester.setText(null);

            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (val1.getText().toString().isEmpty() || val2.getText().toString().isEmpty() ||val3.getText().toString().isEmpty()||val4.getText().toString().isEmpty()||val5.getText().toString().isEmpty() ||
                    val6.getText().toString().isEmpty() || val7.getText().toString().isEmpty() || val8.getText().toString().isEmpty()) {
                Toast.makeText(sgpaprog.this, "completely fill all credentials.", Toast.LENGTH_SHORT).show();
            }else {
                if (val9.getText().toString().isEmpty()) {
                    val9.setText("0");
                }
                String s1 = semester.getText().toString();
                v1 = Integer.parseInt((val1.getText().toString()));
                v2 = Integer.parseInt((val2.getText().toString()));
                v3 = Integer.parseInt((val3.getText().toString()));
                v4 = Integer.parseInt((val4.getText().toString()));
                v5 = Integer.parseInt((val5.getText().toString()));
                v6 = Integer.parseInt((val6.getText().toString()));
                v7 = Integer.parseInt((val7.getText().toString()));
                v8 = Integer.parseInt((val8.getText().toString()));
                v9 = Integer.parseInt((val9.getText().toString()));
                if (v1 == 0 || v2 == 0 || v3 == 0 || v4 == 0 || v5 == 0 || v6 == 0 || v7 == 0 || v8 == 0) {
                    Toast.makeText(sgpaprog.this, "completely fill all credentials.", Toast.LENGTH_SHORT).show();
                } else {
                    float RESULT = calci(v1, v2, v3, v4, v5, v6, v7, v8, v9, s1);
                    String b = Float.toString(RESULT);
                    Result.setText(b);
                }
            }
        }
    });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = semester.getText().toString();
                if(!s.isEmpty()){
                    if(s.equals("1") ||s.equals("2") || s.equals("3") || s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")){
                        Toast.makeText(sgpaprog.this, "okay!! Semester - "+s+".", Toast.LENGTH_SHORT).show();
                        setup(s);
                    }else{
                        Toast.makeText(sgpaprog.this, "Invalid input !!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(sgpaprog.this, "Fill the details.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    float calci(int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,int c9,String sem){
        float result = 0;
        int sum;
        if(sem.equals("1")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
           sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
           result = (float)sum / 20;
        }
        if(sem.equals("2")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
            result = (float)sum / 20;
        }
        if(sem.equals("3")){
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            v9 = convert(v9);
            sum = v1*3 + v2*4 + v3*3 + v4*3 + v5*3 + v6*3 + v7*2 + v8*2 + v9;
            result = (float)sum / 24;
        }
        if(sem.equals("4")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
            result = (float)sum / 20;
        }
        if(sem.equals("5")){
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            v9 = convert(v9);
            sum = v1*3 + v2*4 + v3*4 + v4*3 + v5*3 + v6*3 + v7*1 + v8*1 + v9*2;
            result = (float)sum / 24;
        }
        if(sem.equals("6")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
            result = (float)sum / 20;
        }
        if(sem.equals("7")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
            result = (float)sum / 20;
        }
        if(sem.equals("8")){
            v9 = 0;
            v1 = convert(v1);
            v2 = convert(v2);
            v3 = convert(v3);
            v4 = convert(v4);
            v5 = convert(v5);
            v6 = convert(v6);
            v7 = convert(v7);
            v8 = convert(v8);
            sum = v1*4 + v2*4 + v3*3 + v4*3 + v5*3 + v6 + v7 +v8;
            result = (float)sum / 20;
        }
        return result;
    }
    int convert (int c1){
        if(c1 < 10){
            return 1;
        }
        if(c1 >= 10 && c1 < 20){
            return 2;
        }
        if(c1 >= 20 && c1 < 30){
            return 3;
        }
        if(c1 >= 30 && c1 < 40){
            return 4;
        }
        if(c1 >= 40 && c1 < 50){
            return 5;
        }
        if(c1 >= 50 && c1 < 60){
            return 6;
        }
        if(c1 >= 60 && c1 < 70){
            return 7;
        }
        if(c1 >= 70 && c1 < 80){
            return 8;
        }
        if(c1 >= 80 && c1 <90){
            return 9;
        }
        if(c1 >= 90 && c1 < 100) {
            return 10;
        }
        return 0;
    }
     void setup(String sem) {
        if(sem.equals("1")){
            sub1.setText("18MAT11_");
            sub2.setText("18PHY12_");
            sub3.setText("18ELE13_");
            sub4.setText("18CIV14_");
            sub5.setText("18GDL15_");
            sub6.setText("18PHYL16");
            sub7.setText("18ELEL17");
            sub8.setText("18EGH18_");
            sub9.setText("XXXXXXXX");
        }
         if(sem.equals("2")){
             sub1.setText("18MAT21_");
             sub2.setText("18CHE22_");
             sub3.setText("18CPS23_");
             sub4.setText("18ELN24_");
             sub5.setText("18ME25__");
             sub6.setText("18CHEL26");
             sub7.setText("18CPL27_");
             sub8.setText("18EGH28_");
             sub9.setText("XXXXXXXX");
         }
         if(sem.equals("3")){
             sub1.setText("18MAT31");
             sub2.setText("18CS32_");
             sub3.setText("18CS33_");
             sub4.setText("18CS34_");
             sub5.setText("18CS35_");
             sub6.setText("18CS36_");
             sub7.setText("18CSL37");
             sub8.setText("18CSL38");
             sub9.setText("18KVK39");
         }
         if(sem.equals("4")){
             sub1.setText("18MAT11");
             sub2.setText("18PHY12");
             sub3.setText("18ELE13");
             sub4.setText("18CIV14");
             sub5.setText("18GDL15");
             sub6.setText("18PHYL16");
             sub7.setText("18ELEL17");
             sub8.setText("18EGH18_");
         }
         if(sem.equals("5")){
             sub1.setText("18CS51_");
             sub2.setText("18CS52_");
             sub3.setText("18CS53_");
             sub4.setText("18CS54_");
             sub5.setText("18CS55_");
             sub6.setText("18CS56_");
             sub7.setText("18CSL57");
             sub8.setText("18CSL58");
             sub9.setText("18CIV39");
         }
         if(sem.equals("6")){
             sub1.setText("18MAT11");
             sub2.setText("18PHY12");
             sub3.setText("18ELE13");
             sub4.setText("18CIV14");
             sub5.setText("18GDL15");
             sub6.setText("18PHYL16");
             sub7.setText("18ELEL17");
             sub8.setText("18EGH18");
         }
         if(sem.equals("7")){
             sub1.setText("18MAT11");
             sub2.setText("18PHY12");
             sub3.setText("18ELE13");
             sub4.setText("18CIV14");
             sub5.setText("18GDL15");
             sub6.setText("18PHYL16");
             sub7.setText("18ELEL17");
             sub8.setText("18EGH18");
         }
         if(sem.equals("8")){
             sub1.setText("18MAT11");
             sub2.setText("18PHY12");
             sub3.setText("18ELE13");
             sub4.setText("18CIV14");
             sub5.setText("18GDL15");
             sub6.setText("18PHYL16");
             sub7.setText("18ELEL17");
             sub8.setText("18EGH18");
             sub8.setText("18EGH18");
         }
    }

}