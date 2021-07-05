package com.example.myapplication;

import android.app.DirectAction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

//public class MainActivity extends AppCompatActivity
//        implements View.OnClickListener {
//    //private Button mButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        EditText et1 = (EditText) findViewById(R.id.pt);
//        Button b1 = (Button) findViewById(R.id.button2);
//
//        b1.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view)
//    {
//        EditText et1 = (EditText) findViewById(R.id.pt);
//        Button b1 = (Button) findViewById(R.id.button2);
//
//        b1.setOnClickListener(this);
//        Toast.makeText(this, getString(R.string.label)+et1.getText().toString(), Toast.LENGTH_SHORT).show();
//        Intent i1=new Intent(MainActivity.this,SecondAct.class);
//        String msg = "";
//        i1.putExtra(msg,et1.getText().toString());
//        startActivity(i1);
//    }
//}
public class MainActivity extends AppCompatActivity {

    //private Button mButton;
    public static String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1 = (EditText) findViewById(R.id.pt);
        Button b1 = (Button) findViewById(R.id.button2);


        b1.setOnClickListener(view -> {
            Toast.makeText(this, getString(R.string.label)+et1.getText().toString(), Toast.LENGTH_SHORT).show();
            Intent i1=new Intent(MainActivity.this,SecondAct.class);
            i1.putExtra(msg,et1.getText().toString());
            startActivity(i1);
            //Toast.makeText(this, "Activity"+et1.getText().toString(), Toast.LENGTH_SHORT).show();
        });
    }
}