package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholic.userApp.Adapter.MainFragmentAdapter;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.NavigationTabStrip;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class HomeFragment extends android.support.v4.app.Fragment {

    private Context mContext;
    String[] pageTitles = {"Library", "Explore", "Exam Corner"};


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
        View v = LayoutInflater.from(mContext).inflate(R.layout.home_frag, container,false);
        ViewPager mPager = (ViewPager) v.findViewById(R.id.main_pager);
        NavigationTabStrip mtab = (NavigationTabStrip) v.findViewById(R.id.nav_strip);
        MainFragmentAdapter mAdapter = new MainFragmentAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(3);
        mtab.setTitles(pageTitles);

        mtab.setViewPager(mPager);



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
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
