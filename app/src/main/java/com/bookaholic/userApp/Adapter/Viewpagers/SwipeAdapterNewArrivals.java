package com.bookaholic.userApp.Adapter.Viewpagers;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholic.userApp.Model.Combo;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.ScreenUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;


import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 16/3/17.
 * The Adapter which is used in {@link }
 *
 */

public class SwipeAdapterNewArrivals extends PagerAdapter {




    private List<Combo> mList;
    private Context mContext;
    private ComboInterface mCallback ;

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        (container).removeView((View) object);
    }

    @Override
    public int getCount() {

            return mList.size();

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.image_view_land, container, false);
        SimpleDraweeView image = (SimpleDraweeView) layout.findViewById(R.id.top_image);
        image.setImageURI(Uri.parse(mList.get(position).getImageURL()));
        container.addView(layout);
         return layout;
    }

    public SwipeAdapterNewArrivals(List<Combo> mList, Context mContext, ComboInterface mCallback) {
        this.mList = mList;
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public interface ComboInterface {
        void ComboproductClicked(Combo p);
    }
}

