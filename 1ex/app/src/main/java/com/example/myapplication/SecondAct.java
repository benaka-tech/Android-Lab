package com.example.myapplication;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i2=getIntent();
        Bundle b=i2.getExtras();
        System.out.println(MainActivity.msg);
        Toast.makeText(this, "In Second Activity"+b.getString(MainActivity.msg), Toast.LENGTH_SHORT).show();
    }
}
