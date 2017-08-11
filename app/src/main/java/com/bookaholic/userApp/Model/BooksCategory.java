package com.bookaholic.userApp.Model;

/**
 * Created by nandhu on 23/4/17.
 * The Model which holds category Information
 */

public class BooksCategory {

    public int categoryId;
    public int drawableRes;
    public String name;

    public BooksCategory(int categoryId, int drawableRes, String name) {
        this.categoryId = categoryId;
        this.drawableRes = drawableRes;
        this.name = name;
    }
}
