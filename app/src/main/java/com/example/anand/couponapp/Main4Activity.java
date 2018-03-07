package com.example.anand.couponapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class Main4Activity extends AppCompatActivity {
    ListView lst;
    String[] names={"bigbaazar","amazon","flipkart","goibibo","pvr","swiggy"};
    String optionChosen;

    ImageView bigbazaar,flipkart,goibibo,pvr,swiggy,amazon;
    Button btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        amazon=(ImageView) findViewById(R.id.imageViewamazon);
        bigbazaar=(ImageView)findViewById(R.id.imageViewbigbaazar);
        flipkart=(ImageView)findViewById(R.id.imageViewflipkart);
        goibibo =(ImageView)findViewById(R.id.imageViewgoibibo);
        pvr=(ImageView)findViewById(R.id.imageViewpvr);
        swiggy=(ImageView)findViewById(R.id.imageViewswiggy);


        swiggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","swiggy");
                startActivity(intent);
            }
        });

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","amazon");
                startActivity(intent);
            }
        });
        bigbazaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","bigbaazar");
                startActivity(intent);
            }
        });

        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","flipkart");
                startActivity(intent);
            }
        });


        goibibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","goibibo");
                startActivity(intent);
            }
        });


        pvr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName","pvr");
                startActivity(intent);
            }
        });




        lst= (ListView) findViewById(R.id.lstvw);
                ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        lst.setAdapter(arrayadapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                optionChosen=names[position];

                 intent = new Intent(getApplicationContext(),BrandPage.class);
                intent.putExtra("BrandName",optionChosen);
                startActivity(intent);


            }
        });

    }

}