package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class cgpaprog extends AppCompatActivity {

    private TextView isem1;
    private TextView isem2;
    private TextView isem3;
    private TextView isem4;
    private TextView isem5;
    private TextView isem6;
    private TextView isem7;
    private TextView isem8;
    private TextView iresult;
    private TextView ipercent;
    private Button isubmit;
    private Button iclear;
    private float v1 = 0;
    private float v2 = 0;
    private float v3 = 0;
    private float v4 = 0;
    private float v5 = 0;
    private float v6 = 0;
    private float v7 = 0;
    private float v8 = 0;
    private float sum = 0;
    private Double percent = Double.NaN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        isem1 = findViewById(R.id.editTextTextPersonName2);
        isem2 = findViewById(R.id.editTextTextPersonName3);
        isem3 = findViewById(R.id.editTextTextPersonName5);
        isem4 = findViewById(R.id.editTextTextPersonName4);
        isem5 = findViewById(R.id.editTextTextPersonName6);
        isem6 = findViewById(R.id.editTextTextPersonName7);
        isem7 = findViewById(R.id.editTextTextPersonName9);
        isem8 = findViewById(R.id.editTextTextPersonName10);
        iresult = findViewById(R.id.textView25);
        ipercent = findViewById(R.id.textView26);
        isubmit = findViewById(R.id.button11);
        iclear = findViewById(R.id.button6);

        isubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isem1.getText().toString().isEmpty() || isem2.getText().toString().isEmpty() || isem3.getText().toString().isEmpty() || isem4.getText().toString().isEmpty() ||
                        isem5.getText().toString().isEmpty() || isem6.getText().toString().isEmpty()| isem7.getText().toString().isEmpty() | isem8.getText().toString().isEmpty() ) {

                    Toast.makeText(cgpaprog.this, "completely fill all credentials.", Toast.LENGTH_SHORT).show();

                } else {
                    if (isem5.getText().toString().equals("0")  && isem6.getText().toString().equals("0")  && isem7.getText().toString().equals("0") && isem8.getText().toString().equals("0")) {
                        v1 = Float.parseFloat(isem1.getText().toString());
                        v2 = Float.parseFloat(isem2.getText().toString());
                        v3 = Float.parseFloat(isem3.getText().toString());
                        v4 = Float.parseFloat(isem4.getText().toString());
                        sum = sumation(v1,v2,v3,v4);
                        sum = sum/4;
                        percent = (Double)(sum - 0.75) * 10;
                    }
                    if (isem6.getText().toString().equals("0")  && isem7.getText().toString().equals("0") && isem8.getText().toString().equals("0")) {
                        v1 = Float.parseFloat(isem1.getText().toString());
                        v2 = Float.parseFloat(isem2.getText().toString());
                        v3 = Float.parseFloat(isem3.getText().toString());
                        v4 = Float.parseFloat(isem4.getText().toString());
                        v5 = Float.parseFloat(isem5.getText().toString());
                        sum = sumation(v1,v2,v3,v4,v5);
                        sum = sum/5;
                        percent = (Double)(sum -0.75) * 10;
                    } else if (isem7.getText().toString().equals("0") && isem8.getText().toString().equals("0")) {
                        v1 = Float.parseFloat(isem1.getText().toString());
                        v2 = Float.parseFloat(isem2.getText().toString());
                        v3 = Float.parseFloat(isem3.getText().toString());
                        v4 = Float.parseFloat(isem4.getText().toString());
                        v5 = Float.parseFloat(isem5.getText().toString());
                        v6 = Float.parseFloat(isem6.getText().toString());
                        sum = sumation(v1,v2,v3,v4,v5,v6);
                        sum = sum/6;
                        percent = (Double)(sum -0.75) * 10;
                    }else if(isem8.getText().toString().equals("0")) {
                        v1 = Float.parseFloat(isem1.getText().toString());
                        v2 = Float.parseFloat(isem2.getText().toString());
                        v3 = Float.parseFloat(isem3.getText().toString());
                        v4 = Float.parseFloat(isem4.getText().toString());
                        v5 = Float.parseFloat(isem5.getText().toString());
                        v6 = Float.parseFloat(isem6.getText().toString());
                        v7 = Float.parseFloat(isem7.getText().toString());
                        sum = sumation(v1,v2,v3,v4,v5,v6,v7);
                        sum = sum/7;
                        percent = (Double) (sum -0.75) * 10;
                    }else{
                        v1 = Float.parseFloat(isem1.getText().toString());
                        v2 = Float.parseFloat(isem2.getText().toString());
                        v3 = Float.parseFloat(isem3.getText().toString());
                        v4 = Float.parseFloat(isem4.getText().toString());
                        v5 = Float.parseFloat(isem5.getText().toString());
                        v6 = Float.parseFloat(isem6.getText().toString());
                        v7 = Float.parseFloat(isem7.getText().toString());
                        v8 = Float.parseFloat(isem8.getText().toString());
                        sum = sumation(v1,v2,v3,v4,v5,v6,v7,v8);
                        sum = sum/8;
                        percent = (Double) (sum -0.75) * 10;
                    }
                    iresult.setText(Float.toString(sum).substring(0,4));
                    ipercent.setText(percent.toString().substring(0,5)+"%");
                }
            }
        });
        iclear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                iresult.setText(null);
                ipercent.setText(null);
                isem1.setText(null);
                isem2.setText(null);
                isem3.setText(null);
                isem4.setText(null);
                isem5.setText(null);
                isem6.setText(null);
                isem7.setText(null);
                isem8.setText(null);
            }
        });
    }
        float sumation (float a1,float a2,float a3,float a4,float a5,float a6,float a7,float a8){
            float sum = 0;
            sum = a1+a2+a3+a4+a5+a6+a7+a8;
            return sum;
        }
        float sumation (float a1,float a2,float a3,float a4,float a5,float a6,float a7){
            float sum = 0;
            sum = a1+a2+a3+a4+a5+a6+a7;
            return sum;
        }
        float sumation (float a1,float a2,float a3,float a4,float a5,float a6){
            float sum = 0;
            sum =a1+a2+a3+a4+a5+a6;
            return sum;
        }
    float sumation (float a1,float a2,float a3,float a4,float a5){
        float sum = 0;
        sum = a1+a2+a3+a4+a5;
        return sum;
    }
    float sumation (float a1,float a2,float a3,float a4){
        float sum = 0;
        sum = a1+a2+a3+a4;
        return sum;
    }

}