package com.example.anand.couponapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main4Activity extends AppCompatActivity {
    ListView lst;
    String[] names={"bigbaazar","amazon","flipkart","goibibo","pvr","swiggy"};
    String optionChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lst= (ListView) findViewById(R.id.lstvw);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        lst.setAdapter(arrayadapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                optionChosen=names[position];

                Intent intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName",optionChosen);
                startActivity(intent);


            }
        });
    }
}