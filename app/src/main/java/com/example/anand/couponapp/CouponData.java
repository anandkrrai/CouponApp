package com.example.anand.couponapp;

/**
 * Created by anand on 6/3/18.
 */

public class CouponData {
    private String  brand,image, discount, description,condition, category,extra;

    public CouponData(){

    }

    public CouponData(String brand, String image, String discount,
                      String description, String condition,
                      String category, String extra) {
        this.brand = brand;
        this.image = image;
        this.discount = discount;
        this.description = description;
        this.condition = condition;
        this.category = category;
        this.extra = extra;
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

    public String getDescription() {
        return description;
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
}
