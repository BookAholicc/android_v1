package com.bookaholic.userApp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bookaholic.userApp.Model.Wall;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by nandhu on 26/8/17.
 */

public class WallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Wall> mList;
    Context c;
    WallCallback mCallback;
    LayoutInflater inflater;

    public WallAdapter(List<Wall> mList, Context applicationContext, WallCallback mCallback) {
        this.mList = mList;
        this.c = applicationContext;
        this.mCallback = mCallback;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).isImagePresent){
            return 1;
        }
        else{
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1){

            return new WallItem(inflater.inflate(R.layout.wall_item,parent,false));
        }
        else{
            return new WallImageItem(inflater.inflate(R.layout.wall_image_item,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /*Class for Loading text*/
    public class WallItem extends RecyclerView.ViewHolder{


        public SimpleDraweeView muser;
        public WhitenyBooksFont mWallText;
        public  WhitenyBooksFont likeCont;
        public  WhitenyBooksFont commentsCount;

        public WallItem(View itemView) {
            super(itemView);
        }
    }
        /*Class for Loading Images*/

    public class WallImageItem extends RecyclerView.ViewHolder{

        public WallItem(View itemView) {
            super(itemView);
        }
    }

    public interface WallCallback{
        void showWall(int wallId);

        void likeWall(int wallId);
        void commentWall(int wallId);


    }
}
