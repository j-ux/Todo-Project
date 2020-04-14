package com.example.TodoAPP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("TodoApp");


        ArrayList<String> dataFromdbItem = new ArrayList<>();
        ArrayList<String> dataFromdbDesc = new ArrayList<>();

        ListView lv = (ListView) findViewById(R.id.LVtasks);

        DbHelper dbh = new DbHelper(this);

        Cursor data = dbh.getData();

        while(data.moveToNext()){
            dataFromdbItem.add(data.getString(1));
            dataFromdbDesc.add(data.getString(2));
        }

        Toast.makeText(this,Integer.toString(dataFromdbItem.size()),Toast.LENGTH_LONG).show();

        CustomAdapter ca = new CustomAdapter(this,dataFromdbItem,dataFromdbDesc);
        lv.setAdapter(ca);


    }
}
