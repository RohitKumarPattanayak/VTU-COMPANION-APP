package com.example.vtucompanion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.io.IOException;

public class Profile extends AppCompatActivity {
    ImageView profile_Pic;
    EditText name;
    EditText gmail;
    EditText phno;
    EditText address;
    EditText clgname;
    public SharedPreferences Sp;
    public SharedPreferences.Editor Spe;
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
        Sp = getApplicationContext().getSharedPreferences("DataBase",MODE_PRIVATE);
        Spe = Sp.edit();

        if(Sp != null){
            if(Sp.contains("image_gen")) {
                Picasso.get().load("https://cdn3.vectorstock.com/i/1000x1000/50/12/user-icon-male-person-symbol-profile-avatar-vector-20715012.jpg").into(profile_Pic);
            }
            if(Sp.contains("image_gender")) {
                Picasso.get().load("https://cdn4.vectorstock.com/i/1000x1000/18/98/user-icon-female-person-symbol-profile-avatar-sign-vector-18991898.jpg").into(profile_Pic);
            }
            //imagesettings();
            if(Sp.contains("Profile_name")){
                name.setText(Sp.getString("Profile_name","null"));
            }
            if(Sp.contains("Profile_email")){
                gmail.setText(Sp.getString("Profile_email","null"));
            }
            if(Sp.contains("Profile_phone")){
                phno.setText(Sp.getString("Profile_phone","null"));
            }
            if(Sp.contains("Profile_college")){
                clgname.setText(Sp.getString("Profile_college","null"));
            }
            if(Sp.contains("Profile_address")){
                address.setText(Sp.getString("Profile_address","null"));
            }
        }
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
            String uri = u.toString();
            Spe.putString("image_path",uri);
            //Spe.putString("image_path",data.getData().toString());
            Spe.apply();
            try {
                Bitmap b = MediaStore.Images.Media.getBitmap(getContentResolver(),u);
                profile_Pic.setImageBitmap(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void imagesettings(){
        /*if(Sp.contains("image_path")) {
            Uri u1 = Uri.parse(Sp.getString("image_path", "null"));
            File fileLocation = new File(String.valueOf(u1)); //file path, which can be String, or Uri
            Picasso.with(this).load(fileLocation).into(profile_Pic);
        }*/
        if(Sp.contains("image_path")) {
        Uri u1 = Uri.parse(Sp.getString("image_path", "null"));
        Bitmap b1 = null;
        try {
            b1 = MediaStore.Images.Media.getBitmap(getContentResolver(), u1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile_Pic.setImageBitmap(b1);
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
            Spe.putString("Profile_name",nme);
            Spe.putString("Profile_email",eml);
            Spe.putString("Profile_college",clg);
            Spe.putString("Profile_address",adr);
            Spe.putString("Profile_phone",ph);
            Spe.apply();
            Toast.makeText(Profile.this, "okay registered !!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Profile.this, Insider.class));
        }
    }
    public void clear_profile_info(View view) {
        Spe.remove("Profile_name");
        Spe.remove("Profile_email");
        Spe.remove("Profile_college");
        Spe.remove("Profile_address");
        Spe.remove("Profile_phone");
        //Spe.remove("image_path");
        Spe.remove("image_gen");
        Spe.remove("image_gender");
        //profile_Pic.set;
        Spe.apply();
        name.setText("");
        gmail.setText("");
        address.setText("");
        phno.setText("");
        clgname.setText("");
    }
    public void male(View view) {
        Picasso.get().load("https://cdn3.vectorstock.com/i/1000x1000/50/12/user-icon-male-person-symbol-profile-avatar-vector-20715012.jpg").into(profile_Pic);
        Spe.putString("image_gen","1");
        Spe.apply();
    }
    public void female(View view) {
        Picasso.get().load("https://cdn4.vectorstock.com/i/1000x1000/18/98/user-icon-female-person-symbol-profile-avatar-sign-vector-18991898.jpg").into(profile_Pic);
        Spe.putString("image_gender","1");
        Spe.apply();
    }
}