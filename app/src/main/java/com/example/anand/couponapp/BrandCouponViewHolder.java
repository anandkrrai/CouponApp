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



class BrandCouponViewHolder extends RecyclerView.ViewHolder{
    private final TextView cardscheme;
    private final ImageView imageView;
    private final TextView cardCode;


    public  BrandCouponViewHolder(View itemView){
        super(itemView);
        imageView= (ImageView)itemView.findViewById(R.id.imageViewBrand);
        cardscheme=(TextView)itemView.findViewById(R.id.textViewBrandscheme);
        cardCode=(TextView)itemView.findViewById(R.id.textViewBrandcode);

    }

    public  void setCardscheme(String scheme){
        cardscheme.setText(scheme);
    }

    public void setImage(Context context , String image){
        Picasso.with(context).load(image).into(imageView);
    }

    public void setCardCode(String code){
        cardCode.setText(code);
    }

}
