package com.bookaholic.userApp.Adapter.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.bookaholic.userApp.utils.ScreenUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Adapter used for Disaplaying in HorizontalAdapter Scrolling Fashionn
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizaontalItem> {


    private final String TAG = "HOR_ADAPTER";
    private final int cellSize;
    private Context mContext;
    private List<MiniProduct> mList;
    private Horizontalcallback mCallback;


    public HorizontalAdapter(Context mContext, List<MiniProduct> mList, Horizontalcallback mCallback) {
        this.mContext = mContext;
        this.mList = mList;
        this.mCallback = mCallback;
        this.cellSize = ScreenUtil.getScreenWidth(mContext) / 3;


    }

    @Override
    public HorizontalAdapter.HorizaontalItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalAdapter.HorizaontalItem(LayoutInflater.from(mContext).inflate(R.layout.horizontal_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final HorizontalAdapter.HorizaontalItem holder, int position) {
       final MiniProduct p =  mList.get(position);


        Picasso.with(mContext)   //set Image
                .load(p.getProductImage())
                .resize(600,800)
                .centerCrop()
                .into(holder.mProductImage);



        holder.mProductName.setText(p.getProductName());

        holder.mProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null){
                    mCallback.productClicked(p.getPid());
                }
            }
        });


    }


    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: "+mList.size());
        return mList.size();

    }


    /**
     * The View Holder Class for this list
     */
    public static class HorizaontalItem extends RecyclerView.ViewHolder {
        ImageView mProductImage;
        WhitenyBooksFont mProductName;

        TextView mPriceText;


        public HorizaontalItem(View itemView) {
            super(itemView);

            mProductImage = (ImageView) itemView.findViewById(R.id.h_p_item_image);
            mProductName = (WhitenyBooksFont) itemView.findViewById(R.id.h_p_item_name);

            mPriceText = (TextView) itemView.findViewById(R.id.h_p_item_price_text);

        }
    }

    public interface Horizontalcallback {
        void productClicked(int pid);
    }
}
