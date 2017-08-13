package com.bookaholic.userApp.Adapter.Viewpagers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bookaholic.userApp.Model.Combo;
import com.bookaholic.userApp.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Adapter used in {@link com.bookaholic.userApp.MainPage.EntryGridFragment}
 * It Provides st Images separated by a margin
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder>{


    private  List<Drawable> mDrwabales;
    private Context mContext;
    private  List<Combo> mList;
    private ImageCallback mCallback;





    public ImageAdapter(Context mContext, List<Combo> mComboList, ImageCallback callback) {
        this.mCallback  = callback;
        this.mContext = mContext;
        this.mList = mComboList;

    }

    public ImageAdapter(Context mContext, ImageCallback mCallback, List<Drawable> mDrawables) {
        this.mContext = mContext;
        this.mDrwabales = mDrawables;
        this.mCallback = mCallback;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     return new ImageHolder(LayoutInflater.from(mContext).inflate(R.layout.image_view_land,parent,false));
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, final int position) {

        final  int pos = position;
        holder.mImageView.setImageURI(Uri.parse(mList.get(position).getImageURL()));
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null){
                    mCallback.imageClicked(mList.get(pos).getComboId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ImageHolder extends RecyclerView.ViewHolder{


        private SimpleDraweeView mImageView;


        public ImageHolder(View itemView) {
            super(itemView);
            mImageView = (SimpleDraweeView) itemView.findViewById(R.id.top_image);

        }
    }

    public interface ImageCallback{
        void imageClicked(int pid);
    }



}
