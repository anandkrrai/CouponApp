package com.example.anand.couponapp;

/**
 * Created by anand on 7/3/18.
 */

class BrandCouponData {
    String image,code,scheme;

    public BrandCouponData() {
    }

    public BrandCouponData(String image, String code, String scheme) {
        this.image = image;
        this.code = code;
        this.scheme = scheme;
    }

    public String getImage() {
        return image;
    }

    public String getCode() {
        return code;
    }

    public String getScheme() {
        return scheme;
    }
}
