package com.bookaholic.userApp.MainPage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholic.userApp.Model.EntryViewModel;

import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.BadgedFourThreeImageView;
import com.bookaholic.userApp.UI.OpenSansTextView;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.bookaholic.userApp.utils.ScreenUtil;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 30/7/17..
 *
 *
 */

class EntryFeedAdapter extends RecyclerView.Adapter<EntryFeedAdapter.Product1Vew> {
    private final LayoutInflater layoutInflater;
    private  List<EntryViewModel> l =new ArrayList<>();
    Activity m;
    private  EntryItemCallbacks mCallback;


    public EntryFeedAdapter(List<EntryViewModel> mProductsList, Activity hostActivity, EntryGridFragment entryGridFragment) {
        this.l = mProductsList;
        layoutInflater = LayoutInflater.from(hostActivity);
        m = hostActivity;
        this.mCallback = (EntryItemCallbacks) entryGridFragment;
    }

    @Override
    public Product1Vew onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Product1Vew(layoutInflater.inflate(R.layout.entry_item, parent, false));

    }


    @Override
    public void onBindViewHolder(final Product1Vew holder, int position) {




        if (holder instanceof Product1Vew) {
            Uri uri = Uri.parse(l.get(position).imageURL);

            holder.image.setImageURI(uri);



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ((Product1Vew) holder).image.setTransitionName("" + position);
            }
            ((Product1Vew) holder).mText.setText(l.get(position).productName);

//            ((Product1Vew) holder).mprice7.setText(String.format("%s %s", m.getString(R.string.rs), l.get(position).price7));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EntryViewModel m  = getItem(holder.getAdapterPosition());
                    if (m != null){
                        mCallback.showProduct(m,holder);
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


    private EntryViewModel getItem(int position) {
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
        void addToCart();

        void addToWishlist();

        void showProduct(EntryViewModel id, RecyclerView.ViewHolder holder);
    }


    // Package
    static class Product1Vew extends RecyclerView.ViewHolder {

        SimpleDraweeView image;
        WhitenyBooksFont mText;
        OpenSansTextView mprice7;

        Product1Vew(View itemView) {
            super(itemView);
            mText = (WhitenyBooksFont) itemView.findViewById(R.id.e_i_pname);
            image = (SimpleDraweeView) itemView.findViewById(R.id.e_i_image);

        }
    }


}
