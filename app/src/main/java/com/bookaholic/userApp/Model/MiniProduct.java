package com.bookaholic.userApp.Model;

/**
 * Created by nandhu on 1/6/17.
 * The Small Product Description used in {@link Combo}
 */

public class MiniProduct {
    private String productName;
    private int pid;
    private String productImage;
    private int  price7;

    public MiniProduct(String productName,String productImage, int pid,  int price7) {
        this.productName = productName;
        this.pid = pid;
        this.productImage = productImage;
        this.price7 = price7;
    }

    public MiniProduct(String productName,  String productImage,int pid) {
        this.productName = productName;
        this.pid = pid;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getPrice7() {
        return price7;
    }

    public void setPrice7(int price7) {
        this.price7 = price7;
    }
}
