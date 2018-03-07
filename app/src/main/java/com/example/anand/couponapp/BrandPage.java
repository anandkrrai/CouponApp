package com.example.anand.couponapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BrandPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_page);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("amazon");
        databaseReference.keepSynced(true);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewBrand);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<BrandCouponData,BrandCouponViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<BrandCouponData, BrandCouponViewHolder>
                (BrandCouponData.class,R.layout.brandcadrow,BrandCouponViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(BrandCouponViewHolder viewHolder, BrandCouponData model, int position) {

                viewHolder.setCardCode(model.getCode());
                viewHolder.setCardscheme(model.getScheme());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
