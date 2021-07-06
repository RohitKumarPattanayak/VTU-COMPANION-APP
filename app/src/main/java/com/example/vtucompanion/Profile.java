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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toast.makeText(Profile.this,"Enter All Details Completely.",Toast.LENGTH_SHORT).show();
        profile_Pic = findViewById(R.id.Profile_pic);
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
        Toast.makeText(Profile.this,"okay registered !!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Profile.this,Insider.class));
    }
}