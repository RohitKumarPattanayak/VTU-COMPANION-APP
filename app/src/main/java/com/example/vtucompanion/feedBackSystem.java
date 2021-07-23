package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class feedBackSystem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_system);

    }

    public void call_sent(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:9019435524"));
        startActivity(i);
    }

    public void wtsapp(View view) {
        try {
            String headerReceiver = "THIS IS A FEED-BACK !";// Replace with your message.
            String bodyMessageFormal = "FEED-BACK DISCRICPTION :";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;

            String N = "+919019435524"; //10 digit number
            Intent i = new Intent ();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://wa.me/" + N + "/?text=" + whatsappContain));
            startActivity (i);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}