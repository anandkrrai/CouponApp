package com.example.anand.couponapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by anand on 7/3/18.
 */
public class GridViewAdapter extends BaseAdapter {

    String[] names={"bigbaazar","amazon","flipkart","goibibo","pvr","swiggy"};
    int[] images={R.drawable.bigbaazar,R.drawable.amazon,R.drawable.flipkart,
            R.drawable.goibibo,R.drawable.pvr,R.drawable.swiggy};

    Context context;

    public GridViewAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ImageView imageView;
        imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
//        imageView.setLayoutParams(new GridLayout.LayoutParams(062,50));


        return imageView;
    }
}
