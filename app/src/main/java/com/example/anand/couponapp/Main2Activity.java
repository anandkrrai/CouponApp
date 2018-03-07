package com.example.anand.couponapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    Button btn;
    GridView gridView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn=(Button)findViewById(R.id.buttontry);

        listView= (ListView)findViewById(R.id.listView);

        GridViewAdapter adapter = new GridViewAdapter(Main2Activity.this);

        listView.setAdapter(adapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Main2Activity.this,BrandPage.class);
                    startActivity(intent
                    );
                }
            });
    }
}
