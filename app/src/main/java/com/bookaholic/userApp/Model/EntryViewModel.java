package com.bookaholic.userApp.Model;

/**
 * Created by nandhu on 30/7/17.
 *
 */

public class EntryViewModel {

    public  int pid;
    public String productName;
    public String oneLiner;
    public String authorName;
    public String publisherName;
    //Summary

    public String bookSummary;
    public String imageURL;
    public String baseCategory;
    public String subCategory;
    //language
    public String language;

   public int MRP;
    public int isTopRated;
    public int isBestSeller;
    //q
    public int quantity;
    public int ISBN;
    public int pages;
    public int readingDuration;
    //p
    public int price7;
    public int price15;
    public int price30;
    public boolean isCombo;


    public EntryViewModel(int pid, String productName, String oneLiner, String authorName, String publisherName, String bookSummary, String imageURL, String baseCategory, String subCategory, String language, int MRP, int isTopRated, int isBestSeller, int quantity, int ISBN, int pages, int readingDuration, int price7, int price15, int price30,boolean isCo) {
        this.pid = pid;
        this.productName = productName;
        this.oneLiner = oneLiner;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.bookSummary = bookSummary;
        this.imageURL = imageURL;
        this.baseCategory = baseCategory;
        this.subCategory = subCategory;
        this.language = language;
        this.MRP = MRP;
        this.isTopRated = isTopRated;
        this.isBestSeller = isBestSeller;
        this.quantity = quantity;
        this.ISBN = ISBN;
        this.pages = pages;
        this.readingDuration = readingDuration;
        this.price7 = price7;
        this.price15 = price15;
        this.price30 = price30;
        this.isCombo = isCo;
    }
}
//  pid:'',
//          productName:'',
//          oneLiner:'',
//          authorName:'',
//          publisherName:'',
//          MRP : '',
//          isTopRated:'',
//          isBestSeller:'',
//          bookSummary:'',
//          imageURL:'',
//          baseCategory:'',
//          subCategory:'',
//          quantity : '',
//          ISBN:'',
//          pages:'',
//          readingDuration:'',
//          language:'',
//          sources:[],
//          price7:'',
//          price15:'',
//          price30:''