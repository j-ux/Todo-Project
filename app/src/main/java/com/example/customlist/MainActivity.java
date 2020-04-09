package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void addbtn(View v){

        EditText item = (EditText) findViewById(R.id.ETName);
        EditText desc = (EditText) findViewById(R.id.ETDesc);

        DbHelper dbh = new DbHelper(this);

        boolean result = dbh.add(item.getText().toString(),desc.getText().toString());

        if(result){
            Toast.makeText(this,"Task added",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Task not added",Toast.LENGTH_LONG).show();

        }
    }

    public void list(View v){

        Intent i = new Intent(MainActivity.this,ShowActivity.class);
        startActivity(i);
    }
}
