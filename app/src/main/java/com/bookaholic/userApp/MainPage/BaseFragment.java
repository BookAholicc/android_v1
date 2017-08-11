package com.bookaholic.userApp.MainPage;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by nandhu on 30/7/17.
 *
 */

public class BaseFragment extends Fragment {


    private final String TAG = "basefragment";
    protected  int a  = 5;


    public BaseFragment() {
        super();
        Log.d(TAG, "BaseFragment: Constructor Called ");
    }

    protected  int  getA(){
        return a;
    }
}
