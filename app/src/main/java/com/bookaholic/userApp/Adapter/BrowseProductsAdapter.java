package com.bookaholic.userApp.Adapter;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 25/8/17.
 *
 */

public class BrowseProductsAdapter extends RecyclerView.Adapter<BrowseProductsAdapter.BpPortrait> {
    private final LayoutInflater layoutInflater;
    private  List<MiniProduct> l =new ArrayList<>();
    Activity m;
    private BrowseProductsAdapter.EntryItemCallbacks mCallback;


    public BrowseProductsAdapter(List<MiniProduct> mProductsList, Activity hostActivity, EntryItemCallbacks mCallback) {
        this.l = mProductsList;
        layoutInflater = LayoutInflater.from(hostActivity);
        m = hostActivity;
        this.mCallback = (BrowseProductsAdapter.EntryItemCallbacks) mCallback;
    }

    @Override
    public BrowseProductsAdapter.BpPortrait onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BrowseProductsAdapter.BpPortrait(layoutInflater.inflate(R.layout.grid_item, parent, false));

    }


    @Override
    public void onBindViewHolder(final BpPortrait holder, int position) {




        if (holder instanceof BrowseProductsAdapter.BpPortrait) {
            Uri uri = Uri.parse(l.get(position).getProductImage());

            holder.mImage.setImageURI(uri);



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ((BrowseProductsAdapter.BpPortrait) holder).mImage.setTransitionName("" + position);
            }
            ((BpPortrait) holder).mName.setText(l.get(position).getProductName());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MiniProduct m  = getItem(holder.getAdapterPosition());
                    if (m != null){
                        mCallback.showProduct(m,holder);
                    }
                }
            });
            holder.mList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MiniProduct p  = getItem(holder.getAdapterPosition());
                    if (p!= null){
                        mCallback.addToWishlist(p);
                    }
                }
            });

            holder.mAddtoCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MiniProduct p = getItem(holder.getAdapterPosition());
                    if (p != null){
                        mCallback.addToCart(p);
                    }
                }
            });

        }
//        if (holder instanceof Product2View) {
//            Picasso.with(m)
//                    .load(l.get(position).image)
//                    .into(((Product1Vew) holder).image);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                ((Product1Vew) holder).image.setTransitionName("" + position);
//            }
//
//        }
//
//        if (holder instanceof Product3View) {
//
//            Picasso.with(m)
//                    .load(l.get(position).image)
//
//                    .into(((Product1Vew) holder).image);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                ((Product1Vew) holder).image.setTransitionName("" + position);
//            }
//
//        }
//

        // need both placeholder & background to prevent seeing through shot as it fades in
    }


    private MiniProduct getItem(int position) {
        return l.get(position);
    }

    public int getItemColumnSpan(int position) {

        return  position;
    }



    @Override
    public int getItemCount() {
        return l.size();
    }

    private void expandPopularItems() {
        // for now just expand the first dribbble image per page which should be
//        // the most popular according to our weighing & sorting
//        List<Integer> expandedPositions = new ArrayList<>();
//        int page = -1;
//        final int count = l.size();
//        for (int i = 0; i < count; i++) {
//            EntryViewModel item = getItem(i);
//            if (item instanceof EntryViewModel && item.isCom) {
//                item.colspan = 2;
//                page = item.id;
//                expandedPositions.add(i);
//            } else {
//                item.colspan = 1;
//            }
    }

    // make sure that any expanded items are at the start of a row
//        // so that we don't leave any gaps in the grid
//        for (int expandedPos = 0; expandedPos < expandedPositions.size(); expandedPos++) {
//            int pos = expandedPositions.get(expandedPos);
//            int extraSpannedSpaces = expandedPos * (2 - 1);
//            int rowPosition = (pos + extraSpannedSpaces) % 2;
//            if (rowPosition != 0) {
//                int swapWith = pos + (2 - rowPosition);
//                if (swapWith < l.size()) {
//                    Collections.swap(l, pos, swapWith);
//                }
//            }
//        }
//    }



    public interface EntryItemCallbacks {
        void addToCart(MiniProduct p);

        void addToWishlist(MiniProduct p);

        void showProduct(MiniProduct id, RecyclerView.ViewHolder holder);
    }


    // Package
    static class BpPortrait extends RecyclerView.ViewHolder {

        SimpleDraweeView mImage;
        WhitenyBooksFont mName;
        ImageView mList;
        ImageView mAddtoCart;


        BpPortrait(View itemView) {
            super(itemView);
            mImage = (SimpleDraweeView) itemView.findViewById(R.id.grid_image);
            mName = (WhitenyBooksFont) itemView.findViewById(R.id.grid_name);
            mList = (ImageView) itemView.findViewById(R.id.wish_item);
            mAddtoCart = (ImageView) itemView.findViewById(R.id.cart_item);
        }
    }


}

