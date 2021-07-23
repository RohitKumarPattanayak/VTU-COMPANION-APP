package com.example.vtucompanion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private TextView VCRegister;
    private TextView VCUser;
    private TextView VCPass;
    private Button VClogin;
    private TextView VCAttempts;
    private CheckBox VCremember;
    public static String forinsider;
    //    public static String User ="Rohit" ;
//    public static String Pass = "12345678";
    boolean isValid = false;
    int i = 5;
    public Credentials A1;
    SharedPreferences Sp;
    SharedPreferences.Editor Spe;
//    public static Credentials A =  new Credentials("Rohit","password");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        VCUser = findViewById(R.id.editTextTextPersonName);
        VCPass = findViewById(R.id.editTextTextPassword2);
        VClogin = findViewById(R.id.button);
        VCRegister = findViewById(R.id.textView10);
        VCAttempts = findViewById(R.id.textView14);
        VCremember =findViewById(R.id.checkBox);

        A1 = new Credentials();
        Sp = getApplicationContext().getSharedPreferences("DataBase",MODE_PRIVATE);      //it creates a file DataBase and Store a copy of all the value of that file by getSharedpreferences.
        Spe = Sp.edit();


        if(Sp != null){
            Map<String,?> prefs = Sp.getAll();
            if(prefs.size()!=0){
                A1.loadCred(prefs);
            }
            String SavedUser = Sp.getString("LastUsername","");
            String SavedPass = Sp.getString("LastUserPass","");

            if(Sp.getBoolean("rememberMe",false)){
                VCUser.setText(SavedUser);
                VCPass.setText(SavedPass);
                VCremember.setChecked(true);
            }
        }
        VCremember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spe.putBoolean("rememberMe",VCremember.isChecked());
                Spe.apply();
            }
        });
        VCRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registration.class));
            }
        });
        VClogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUser = VCUser.getText().toString();
                String inputPass = VCPass.getText().toString();

                isValid = Verify(inputUser,inputPass);
                if (inputUser.isEmpty() || inputPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Completely fill all details.", Toast.LENGTH_SHORT).show();

                } else {
                    if (!isValid) {
                        i--;
                        VCAttempts.setText("no. of Attempts Remaining : " + i);
                        if (i == 0) {
                            VClogin.setEnabled(false);
                        }
                        Toast.makeText(MainActivity.this, "Invalid detailss", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "If new User? then Register below.", Toast.LENGTH_SHORT).show();

                    } else {
                        forinsider =VCUser.getText().toString();
                        Toast.makeText(MainActivity.this, "Login Succesfull!", Toast.LENGTH_SHORT).show();
                        Spe.putString("LastUsername",inputUser);
                        Spe.putString("LastUserPass",inputPass);
                        Spe.apply();
                        Intent i = new Intent(MainActivity.this, Insider.class);
                        startActivity(i);
                    }
                }
            }
        });
    }

    public boolean Verify(String a, String b) {
    return A1.VerifyCred(a,b);
    }

}