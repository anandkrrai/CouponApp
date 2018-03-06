package com.example.anand.couponapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by anand on 7/3/18.
 */

class CouponViewHolder extends RecyclerView.ViewHolder{
    private final TextView cardTitle;
    private final TextView cardDiscount;
    private final ImageView imageView;


    public CouponViewHolder(View itemView) {

        super(itemView);
        cardTitle= (TextView)itemView.findViewById(R.id.textViewRow);
        cardDiscount= (TextView)itemView.findViewById(R.id.textViewRowDescription);
        imageView= (ImageView)itemView.findViewById(R.id.imageViewRow);


    }
    public void setTitle(String title){
        cardTitle.setText(title);
    }

    public void setDesc(String desc){
        cardTitle.setText(desc);
    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);

    }
}
