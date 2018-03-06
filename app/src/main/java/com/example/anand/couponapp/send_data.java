package com.example.anand.couponapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class send_data extends AppCompatActivity {

    TextView brand,image, discount, description,condition, category,extra;
    Button btn;

    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();

        brand=(TextView)findViewById(R.id.BrandName);
        image=(TextView)findViewById(R.id.Imageurl);
        discount=(TextView)findViewById(R.id.Discount);
//        description=(TextView)findViewById(R.id.);
        condition=(TextView)findViewById(R.id.conditionApply);
        category=(TextView)findViewById(R.id.category);
        extra=(TextView)findViewById(R.id.extra);

        btn=(Button)findViewById(R.id.btnSendata);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CouponData couponData = new CouponData(brand.getText().toString(),
                        image.getText().toString(),discount.getText().toString(),
                        description.getText().toString(),condition.getText().toString()
                        ,category.getText().toString(),extra.getText().toString());
            }
        });

    }
}
