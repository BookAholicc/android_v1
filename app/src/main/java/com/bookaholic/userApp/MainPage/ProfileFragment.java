package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookaholic.userApp.Onboarding.UserWelcomeActivity;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.bookaholic.userApp.utils.DataStore;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class ProfileFragment extends android.support.v4.app.Fragment {

    CollapsingToolbarLayout mCollapsingToolbar;

    TabLayout mTabLayout;

    ViewPager mPager;




    ImageView mBackgroundImage;

    ImageView mProfileImage;

    WhitenyBooksFont mName;

    private Context mContext;

    DataStore mStore;
    private Bitmap backGroundImage;


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
         v = LayoutInflater.from(mContext).inflate(R.layout.profile_frag, container,false);


        DataStore mStore  = DataStore.getStorageInstance(mContext);
        if (mStore.isLoggedIn()){

            String name = mStore.getUserName();
            String email = mStore.getEmail();
            String photoUrl = mStore.getpicturePath();



        }
        else {
            // No user is signed in
            mContext.startActivity(new Intent(getActivity(),UserWelcomeActivity.class));
        }



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

        if (v != null){

            mCollapsingToolbar = (CollapsingToolbarLayout)v.findViewById(R.id.profile_collapsing_toolbar);
            mTabLayout = (TabLayout) v.findViewById(R.id.profile_tab);
            mPager = (ViewPager) v.findViewById(R.id.profile_pager);
            mBackgroundImage = (ImageView) v.findViewById(R.id.profile_bg_image);
            mProfileImage = (ImageView) v.findViewById(R.id.profile_image);
            mName = (WhitenyBooksFont) v.findViewById(R.id.profile_name);

        }
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