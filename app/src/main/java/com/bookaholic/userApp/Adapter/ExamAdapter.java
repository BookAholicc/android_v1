package com.bookaholic.userApp.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholic.userApp.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by nandhu on 13/8/17.
 */

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.Examitem>{



    private Context mContext;
    private ExamCallbacks m;
    private LayoutInflater l;
    public ExamAdapter(Context c,ExamCallbacks examCallbacks) {
        mContext = c;
        m = examCallbacks;
        l = LayoutInflater.from(mContext);

    }

    @Override
    public Examitem onCreateViewHolder(ViewGroup parent, int viewType) {
      return   new Examitem(l.inflate(R.layout.exam_item,parent,false));
    }

    @Override
    public void onBindViewHolder(Examitem holder, final int position) {

        final int pos = position;
        holder.mImage.setActualImageResource(getExamIamge(position));
        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m != null){
                    m.examClicked(pos);
                }
            }
        });
    }

    private int getExamIamge(int position) {
        switch (position){
            case 0:
                return R.mipmap.sii;
            case 1:
                return R.mipmap.sa;
            case 2:
                return R.mipmap.iaf;
            case 3:
                return R.mipmap.psu;
            case 4:
                return R.mipmap.cs;
          default:

              break;




        }
        return R.mipmap.ic_launcher;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class  Examitem extends RecyclerView.ViewHolder{


        SimpleDraweeView mImage;
        public Examitem(View itemView) {
            super(itemView);
            mImage = (SimpleDraweeView)itemView.findViewById(R.id.exam_image);

        }
    }

    public interface  ExamCallbacks{
        void examClicked(int Examid);
    }
}
