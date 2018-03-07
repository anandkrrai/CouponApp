package com.example.anand.couponapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.differentView);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();
        databaseReference.keepSynced(true);

        recyclerView=(RecyclerView)findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<CouponData,CouponViewHolder> firebaseRecyclerAdapter = new
                FirebaseRecyclerAdapter<CouponData, CouponViewHolder>
                (CouponData.class,R.layout.cardrow,CouponViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(CouponViewHolder viewHolder, CouponData model, int position) {
                    viewHolder.setTitle(model.getBrand());
//                viewHolder.setCardCategory(model.getCategory());
                    viewHolder.setDiscount(model.getDiscount());
                    viewHolder.setCardCondition(model.getCondition());
                    viewHolder.setImage(getApplicationContext(), model.getImage());
                }

        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


    }

