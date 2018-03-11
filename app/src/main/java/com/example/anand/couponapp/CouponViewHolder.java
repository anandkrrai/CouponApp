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
    private final TextView cardBrand;
    private final TextView cardDiscount;
    private final TextView cardCondition;
    private final ImageView imageView;



    public CouponViewHolder(View itemView) {

        super(itemView);

        imageView= (ImageView)itemView.findViewById(R.id.imageViewRow);
        cardBrand= (TextView)itemView.findViewById(R.id.textViewRow);
        cardDiscount= (TextView)itemView.findViewById(R.id.textViewRowDiscount);
        cardCondition=(TextView)itemView.findViewById(R.id.textViewRowCondition);

    }
    public void setTitle(String title){
        cardBrand.setText(title);
    }

    public void setDiscount(String discount){
        cardDiscount.setText(discount);
    }

    public void setCardCondition(String condition){
        cardCondition.setText(condition);
    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);
    }

}
