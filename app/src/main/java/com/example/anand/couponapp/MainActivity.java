package com.example.anand.couponapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();
        databaseReference.keepSynced(true);


        recyclerView=(RecyclerView)findViewById(R.id.RecyclerView);
//        recyclerView.setHasFixedSize(true);  //damn

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                viewHolder.setDesc(model.getDiscount());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


    }

