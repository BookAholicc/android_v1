package com.bookaholic.userApp.utils;

import android.content.Context;
import android.util.Log;

import com.bookaholic.userApp.Model.Combo;
import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.Model.Product;
import com.bookaholic.userApp.Model.Wall;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 9/3/17.
 * Helper class to Handle Cart Functionality
 *
 *It performs add ,remove to {@link com.bookaholic.userApp.Model.CartModel } from cart
 *
 * Cart model if Different From Product Model
 */

public class CartHandler  {

    private static final String TAG = "CART_HANDLER";
    private List<MiniProduct> mCartProducts;

    private Context mContext =  null;
    private DataStore mDataStore  = null;
    private static CartHandler mCartHandler;

    public CartHandler(Context mContext) {
        this.mContext = mContext;
        mDataStore  = DataStore.getStorageInstance(mContext);

    }



    public static synchronized CartHandler getInstance(Context context) {
        if (mCartHandler == null) {
            mCartHandler = new CartHandler(context);
        }
        return mCartHandler;
    }

    /*First Update the Local Vairable All together
    * and wirte the whole variable ,
    *

    * */
    public boolean addProductToCart(MiniProduct p ){
       //Firt Chekc whether user have Already Saved some Products


        //First Get the Product in Cart Storage
        mCartProducts = getProducts();


        if (mCartProducts == null){
            Log.d(TAG, "Cart Product is null");
            mCartProducts = new ArrayList<>();
        }

        //Check Whether The Cart Has Already the Same Product
        for (int i = 0; i< mCartProducts.size(); i++){

            MiniProduct model = mCartProducts.get(i);
            if (p.getPid() == model.getPid()){
                //model Already exists
                Log.d(TAG, "addProductToCart: product alrady Exists so not added");
                return false;
            }

        }

        //No Product Exists

        //Append The Product to Cart
        mCartProducts.add(p);

        //save The new List to Storage
         mDataStore.saveCartList(mCartProducts);
        return true;
    }



    public  void addProductstoCart(List<MiniProduct> mList){
            // First Get the Products From Cart
        mCartProducts = getProducts();
        Log.d(TAG, "addProductstoCart: Current List "+mList);
                // check Against Each Product in List

    }


    public  List<MiniProduct> getProducts(){
        if(mDataStore == null){
            mDataStore = DataStore.getStorageInstance(mContext);
        }
        return mDataStore.getCartProducts();
    }






    /**
     * Chekcs to See Whether the Product is Adlready in Cart or Not
     *
     * {@param p - The product}
     *
     *          Returns True - if Present
     *
     * */



    public void removeProduct(Product p) {

        //First get the Products
        mCartProducts = getProducts();
        if (mCartProducts == null){
            //iF no product present , return
            return;
        }



        for (int i = 0; i< mCartProducts.size(); i++){
            MiniProduct model = mCartProducts.get(i);
            // same Product Id exists , remove that product;
            if (p.getPid() == model.getPid()){
                 mCartProducts.remove(i);
            }
        }


        //save the Updated List;
        mDataStore.saveCartList(mCartProducts);

    }


    public List<Combo> getMockCombo() {
        List<Combo> mList = new ArrayList<>();
        mList.add(new Combo(4,"A Combo ","Some Description ","",300,"2 Weeks"));
        mList.add(new Combo(4,"A Combo ","Some Description ","",300,"2 Weeks"));
        mList.add(new Combo(4,"A Combo ","Some Description ","",300,"2 Weeks"));
        mList.add(new Combo(4,"A Combo ","Some Description ","",300,"2 Weeks"));
        return mList;
    }

    public List<MiniProduct> getMockProducts() {
        List<MiniProduct> mList = new ArrayList<>();
        mList.add(new MiniProduct("Losing My Viriginity","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Fto-kill-a-mockingbird-50th-ed.jpg?alt=media&token=3e1093c5-ec20-43c5-b64e-2bbea0ef7c9b",4));
        mList.add(new MiniProduct("Chicken Soup For teenage Souls","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2F900011.jpg?alt=media&token=a96b7363-5734-4526-91cb-26e4ec9fdfe2",4));
        mList.add(new MiniProduct("Master of the Game","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2FIndia%E2%80%99s%20Struggle%20For%20Independence.jpg?alt=media&token=720cbf5e-dd14-4990-acae-95e27d9531d4",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));
        mList.add(new MiniProduct("Thinking Fast & Slow","https://firebasestorage.googleapis.com/v0/b/bookaholic-786.appspot.com/o/productImages%2Fbooks%2Ffull%20life.jpg?alt=media&token=8b2142cc-8024-4b58-a43a-70b99d266263",4));

        return mList;

    }

    public List<Wall> getMockWall() {
        List<Wall> mList  = new ArrayList<>();
//        mList.add()
        return mList;
    }
}
