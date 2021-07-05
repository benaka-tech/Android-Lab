package com.example.a5ex;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button sendBtn;
    Button btnSendEmail;
    Button btnPhone;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);
        btnPhone = (Button) findViewById(R.id.btnDialPhone);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDial();
            }
        });
    }

    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ba.mohan@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body Test");
        startActivity(emailIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void sendSMSMessage() {
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
           // sendIntent.putExtra("sms_body", "default content");
            String phoneNumber="9448827071";
            sendIntent.setData(Uri.parse("smsto:" + Uri.encode(phoneNumber)));
            //sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

    }

    protected void PhoneDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }


}