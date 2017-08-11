package com.bookaholic.userApp.Adapter.Viewpagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bookaholic.userApp.MainPage.ExamDetailFragment.ExamBooksFragment;
import com.bookaholic.userApp.MainPage.ExamDetailFragment.ExamInfoFragment;
import com.bookaholic.userApp.utils.BundleKey;

/**
 * Created by nandhu on 22/7/17.
 * {@link com.bookaholic.userApp.Activity.ExamDetailActivity}
 *
 *
 */

public class ExamDetailsAdapter extends FragmentStatePagerAdapter{

    int examCode;
    public ExamDetailsAdapter(FragmentManager supportFragmentManager, int examCode) {
        super(supportFragmentManager);
        this.examCode = examCode;

    }


    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putInt(BundleKey.ARG_EXAM_BASE,examCode);
        switch (position){
            case 0:
                ExamInfoFragment mFragment = new ExamInfoFragment();
                mFragment.setArguments(b);
                return mFragment;



            case 1:
                ExamBooksFragment mExamBooks = new ExamBooksFragment();
                mExamBooks.setArguments(b);
                return mExamBooks;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
