package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bookaholic.userApp.Activity.ExamDetailActivity;
import com.bookaholic.userApp.Adapter.ExamAdapter;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;

import java.util.List;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class ExamSection extends   android.support.v4.app.Fragment implements ExamAdapter.ExamCallbacks {


    private Context mContext;

    RecyclerView mList;
    View v;

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
        v = LayoutInflater.from(mContext).inflate(R.layout.exam_section_frag, container,false);



        return  v;
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
        mList = (RecyclerView) v.findViewById(R.id.exam_list);
        ExamAdapter mAdapter = new ExamAdapter(mContext,this);
        GridLayoutManager manager  = new GridLayoutManager(mContext,2);
        mList.setLayoutManager(manager);
        mList.setAdapter(mAdapter);
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
    public void examClicked(int Examid) {
        Intent i = new Intent(mContext, ExamDetailActivity.class);
        i.putExtra(APIUtils.EXAM_CODE,Examid);
        startActivity(i);
    }
}