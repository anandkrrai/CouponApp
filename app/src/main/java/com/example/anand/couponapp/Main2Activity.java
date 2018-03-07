package com.example.anand.couponapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    GridView gridView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



//        gridView= (GridView)findViewById(R.id.gridview);
//
//        GridViewAdapter adapter = new GridViewAdapter(Main2Activity.this);
//
//        gridView.setAdapter(adapter);

        listView= (ListView)findViewById(R.id.listView);

        GridViewAdapter adapter = new GridViewAdapter(Main2Activity.this);

        listView.setAdapter(adapter);
    }
}
