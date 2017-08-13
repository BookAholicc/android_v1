package com.bookaholic.userApp.Adapter.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.OpenSansTextView;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by nandhu on 22/6/17.
 *
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Cartholder> {

    private CartCallbacks mCartCallbacks;
    private List<MiniProduct> mlist ;
    private Context mContext;
    private String TAG = "CART_ADAPTER";


    public CartAdapter(List<MiniProduct> mCartList, Context mContext, CartCallbacks mCallback) {
        this.mCartCallbacks = mCallback;
        this.mContext = mContext;
        this.mlist = mCartList;

    }

    @Override
    public Cartholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(mContext).inflate(R.layout.cart_item,parent,false);
        return new Cartholder(v);
    }

    @Override
    public void onBindViewHolder(Cartholder holder, int position) {


        // Cart Products
        holder.mCartImage.setImageURI(mlist.get(position).getProductImage());
        //

        holder.mName.setText(mlist.get(position).getProductName());
        holder.mPrice.setText(String.format("%d", mlist.get(position).getPrice7()));
//        final List<PriceInfo> mInfo = mlist.get(position).getPr();
//        if (mInfo == null){
//            Log.d(TAG, "onBindViewHolder: Null Pricing Adapter");
//        }







        //prepare Adapter for Class SPinner
//        DurationSpinner
//                mAdapter = new DurationSpinner(mContext,R.layout.simple_spinner,mInfo);
//
//        holder.mDurationSpinner.setAdapter(mAdapter);
////        holder.mDurationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
////            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(TAG, "onItemSelected: New Amount for  "+mInfo.get(i).getAmount());
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        holder.itemView.setScaleX(0);
        holder.itemView.setScaleY(0);

        holder.itemView.setAlpha(0.1f);
        holder.itemView.animate().setInterpolator(new DecelerateInterpolator(1.5f))
                .scaleY(1)
                .scaleX(1)
                .alpha(1)
                .setStartDelay(200)
                .setDuration(600)
                .start();



    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class Cartholder extends RecyclerView.ViewHolder{


        SimpleDraweeView mCartImage;
        OpenSansTextView mName;
//        8668108074
        WhitenyBooksFont mPrice;
        Spinner mDurationSpinner;
        OpenSansTextView mPageConunt;
        OpenSansTextView mReadingDuration;
        public Cartholder(View itemView) {
            super(itemView);
            mCartImage = (SimpleDraweeView) itemView.findViewById(R.id.cart_item_image);
            mName = (OpenSansTextView) itemView.findViewById(R.id.cart_item_pname);
            mPrice = (WhitenyBooksFont) itemView.findViewById(R.id.cart_item_price);
            mDurationSpinner = (Spinner) itemView.findViewById(R.id.cart_item_spinner);
            mReadingDuration = (OpenSansTextView) itemView.findViewById(R.id.cart_item_reading_dur);
        }
    }

    public interface CartCallbacks{
        void removeProduct(int pos, MiniProduct p);
        void changeDuration(int pos, int windowId, int newAmount);

    }
}
