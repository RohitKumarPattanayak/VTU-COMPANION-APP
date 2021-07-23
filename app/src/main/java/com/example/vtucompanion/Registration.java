package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class Registration extends AppCompatActivity {

    private TextView RegUser;
    private TextView RegPass;
    private Button VCRegister;
    private boolean isChecked = false;

    public static Credentials A;
    SharedPreferences Sp;
    SharedPreferences.Editor Spe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        RegUser = findViewById(R.id.editTextTextPersonName8);
        RegPass = findViewById(R.id.editTextTextPassword);
        VCRegister = findViewById(R.id.button2);
        A=new Credentials();
        Sp = getApplicationContext().getSharedPreferences("DataBase",MODE_PRIVATE);
        Spe = Sp.edit();
        A = new Credentials();

        if(Sp != null){                                                 //Loading all stuff
            Map<String,?> prefs = Sp.getAll();
            if(prefs.size()!=0)
                A.loadCred(prefs);
        }

        VCRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InputName = RegUser.getText().toString();
                String InputPass = RegPass.getText().toString();

                isChecked =  constraints(InputName,InputPass);
                if(isChecked){
                    if(A.checkUsername(InputName)){
                        Toast.makeText(Registration.this,"Username already exists !",Toast.LENGTH_SHORT).show();
                        A.addCred(InputName,InputPass);
                    }else {
                        Spe.putString(InputName, InputPass);
                        Spe.putString("LastUsername",InputName);                                                         //TRACING NEEDED !!
                        Spe.putString("LastUserPass",InputPass);                                                         //TRACING NEEDED !!


                        Spe.apply();
                        Toast.makeText(Registration.this, "succesfully Registered", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Registration.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
    public boolean constraints(String sN,String sP){
        if(sN.isEmpty() || sP.length()<8 ){
            Toast.makeText(Registration.this,"INVALID !",Toast.LENGTH_SHORT).show();
            Toast.makeText(Registration.this,"Fill All Details , Password should contain \n             atleast 8 CHARECTERS.",Toast.LENGTH_SHORT).show();
        return false;
        }
        return true;
    }
}