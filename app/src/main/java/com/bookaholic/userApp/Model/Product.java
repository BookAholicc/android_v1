package com.bookaholic.userApp.Model;

/**
 * Created by nandhu on 5/2/17.
 * THe Model Class for A product
 *
 *
 *
 * {@param type} == if 0 --set it as book
 *  1 -- set it as book
 *  2 -- set it as console
 *  3 -- set it as games cd
 */




public class Product {
    private int pid;
    private String productName;
    private String oneLiner;
    private String authorName;
    private String  publisherName;
    private int MRP;
    private String imageURL;
    private boolean isTopRated;
    private boolean isBestSeller;
    private String  bookSummary;
    private String  baseCategory;
    private String  subCategory;
    private int quantity;
    private int ISBN;
    private int pages;
    private int readingDuration;
    private String language;

    private int price7;
    private int price15;
    private int  price30;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Product(int pid, String productName, String oneLiner, String authorName, String publisherName, int MRP, String imageURL, int isTopRated, int isBestSeller, String bookSummary, String baseCategory, String subCategory, int quantity, int ISBN, int pages, int readingDuration, int price7, int price15, int price30, String language) {
        this.pid = pid;
        this.productName = productName;
        this.oneLiner = oneLiner;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.MRP = MRP;
        this.imageURL = imageURL;
//        this.isTopRated = isTopRated;
//        this.isBestSeller = isBestSeller;
        this.bookSummary = bookSummary;
        this.baseCategory = baseCategory;
        this.subCategory = subCategory;
        this.quantity = quantity;
        this.ISBN = ISBN;
        this.pages = pages;
        this.readingDuration = readingDuration;
        this.language = language;
        this.price7 = price7;
        this.price15 = price15;
        this.price30 = price30;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOneLiner() {
        return oneLiner;
    }

    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getMRP() {
        return MRP;
    }

    public void setMRP(int MRP) {
        this.MRP = MRP;
    }

    public boolean isTopRated() {
        return isTopRated;
    }

    public void setTopRated(boolean topRated) {
        isTopRated = topRated;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getBaseCategory() {
        return baseCategory;
    }

    public void setBaseCategory(String baseCategory) {
        this.baseCategory = baseCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReadingDuration() {
        return readingDuration;
    }

    public void setReadingDuration(int readingDuration) {
        this.readingDuration = readingDuration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPrice7() {
        return price7;
    }

    public void setPrice7(int price7) {
        this.price7 = price7;
    }

    public int getPrice15() {
        return price15;
    }

    public void setPrice15(int price15) {
        this.price15 = price15;
    }

    public int getPrice30() {
        return price30;
    }

    public void setPrice30(int price30) {
        this.price30 = price30;
    }
}