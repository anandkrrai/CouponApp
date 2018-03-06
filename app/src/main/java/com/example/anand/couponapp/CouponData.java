package com.example.anand.couponapp;

/**
 * Created by anand on 6/3/18.
 */

public class CouponData {
    private String  brand,image, discount,condition, category,extra,featured;

    public CouponData(){

    }

    public CouponData(String brand, String image, String discount,String condition,
                      String category, String extra,String featured) {
        this.brand = brand;
        this.image = image;
        this.discount = discount;
        this.condition = condition;
        this.category = category;
        this.extra = extra;
        this.featured=featured;
    }

    public String getBrand() {
        return brand;
    }

    public String getImage() {
        return image;
    }

    public String getDiscount() {
        return discount;
    }

    public String getCondition() {
        return condition;
    }

    public String getCategory() {
        return category;
    }

    public String getExtra() {
        return extra;
    }

    public String getFeatured() {
        return featured;
    }
}
