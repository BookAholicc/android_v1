package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.bookaholic.userApp.Activity.CheckOutActivity;
import com.bookaholic.userApp.Adapter.List.CartAdapter;
import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.BundleKey;
import com.bookaholic.userApp.utils.CartHandler;
import com.bookaholic.userApp.utils.RVdecorator;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class CartFragment extends android.support.v4.app.Fragment implements CartAdapter.CartCallbacks, View.OnClickListener {
    private Context mContext;


    FrameLayout mRoot;

    List<MiniProduct> pList;
    int totalAmount;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
            mContext = null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mContext == null){
            mContext = context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cart_frag, container,false);

        mRoot = (FrameLayout) v.findViewById(R.id.cart_frame_root);
        pList = CartHandler.getInstance(mContext).getProducts();
        if (pList == null){
            View mNoProductsView = View.inflate(mContext,R.layout.no_ordrers,mRoot);
        }
        else{
            //
            View cartView = View.inflate(mContext,R.layout.cart_view,mRoot);
            CartAdapter mAdapter = new CartAdapter(pList,mContext,this);
            RecyclerView mList = (RecyclerView) cartView.findViewById(R.id.list);
            mList.setAdapter(mAdapter);
            mList.addItemDecoration(new RVdecorator(ContextCompat.getDrawable(mContext,R.drawable.divider)));
            mList.setLayoutManager(new LinearLayoutManager(mContext));
            Button b  = (Button) cartView.findViewById(R.id.check_out_button);
            b.setOnClickListener(this);
            totalAmount = getAmount(pList);

        }



        return  v;
    }


    private int getAmount(List<MiniProduct> mList) {
        int sum = 0;
        for (int i =0;i<mList.size();i++){
            sum = sum + mList.get(i).getPrice7();

        }
        return sum;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void removeProduct(int pos, MiniProduct p) {

    }

    @Override
    public void changeDuration(int pos, int windowId, int newAmount) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_out_button:
                checkOut();
                break;
        }
    }

    private void checkOut() {
        Gson gs  = new Gson();
        String cartString = gs.toJson(pList);

        Intent i = new Intent(mContext,CheckOutActivity.class);
        i.putExtra(BundleKey.ARG_CHECKOUT_STRING,cartString);
        i.putExtra(BundleKey.ARG_PRICE,totalAmount);
        startActivity(i);
    }
}