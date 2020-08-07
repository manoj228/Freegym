package com.example.freegym;

public class ExampleItem {
    private String mText1;
    private int mImageResource;

    public ExampleItem(int imageResource,String text1) {
        mImageResource = imageResource;
        mText1 = text1;    }

    public int getImageResource() {
        return mImageResource;
    }


    public String getText1() {
        return mText1;
    }

}