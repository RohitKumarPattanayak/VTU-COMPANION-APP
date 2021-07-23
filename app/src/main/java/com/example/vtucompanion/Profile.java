package com.example.vtucompanion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class Profile extends AppCompatActivity {
    ImageView profile_Pic;
    EditText name;
    EditText gmail;
    EditText phno;
    EditText address;
    EditText clgname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toast.makeText(Profile.this,"User details!",Toast.LENGTH_SHORT).show();
        profile_Pic = findViewById(R.id.Profile_pic);
        name = findViewById(R.id.profile_name);
        gmail = findViewById(R.id.profile_email);
        phno = findViewById(R.id.number_call);
        address = findViewById(R.id.profile_address);
        clgname = findViewById(R.id.profile_clgName);
    }

    public void Upload(View view) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i,7877);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == 7877 && resultCode == RESULT_OK && data !=null ){
            Uri u = data.getData();
            try {
                Bitmap b = MediaStore.Images.Media.getBitmap(getContentResolver(),u);
                profile_Pic.setImageBitmap(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void submit_details(View view) {
        String nme,eml,clg,ph,adr;
        nme = name.getText().toString();
        eml = gmail.getText().toString();
        clg = clgname.getText().toString();
        ph = phno.getText().toString();
        adr = address.getText().toString();
        if(nme.isEmpty() || eml.isEmpty() || clg.isEmpty() || ph.isEmpty() || adr.isEmpty()){
            Toast.makeText(Profile.this, "enter all details completely!.", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Profile.this, "okay registered !!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Profile.this, Insider.class));
        }
    }
}