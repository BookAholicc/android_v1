package com.bookaholic.userApp.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholic.userApp.MainPage.EntryGridFragment;
import com.bookaholic.userApp.MainPage.ExamSection;
import com.bookaholic.userApp.MainPage.ExploreFragment;


/**
 * Created by nandhu on 20/4/17.
 * The Adapter Which is used in {@link com.bookaholic.userApp.MainActivity}
 *
 *
 */
public class MainFragmentAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = "MainAdapter";
    private Context mContext;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:
                EntryGridFragment mFragment = new EntryGridFragment();
                return  mFragment;
            case 1:
                ExploreFragment mExplore = new ExploreFragment();
                return  mExplore;

            case 2:
                ExamSection mExam = new ExamSection();
                return  mExam;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        Log.d(TAG, "destroyItem: ");
        ((ViewPager) container).removeView((View) object);
    }

    /*  @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "NEW ARRIVALS";
            case 1:
                return "WHAT'S POPULAR";
            case 2:
                return "EXAM CORNER";
            default: return null;
        }
    }*/
}
