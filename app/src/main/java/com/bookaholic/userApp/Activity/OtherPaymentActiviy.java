package com.bookaholic.userApp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bookaholic.userApp.R;


/**
 * Created by nandhu on 23/7/17.
 *  Other payment Activities
 *  this should Always Start with method StartActivity for Result Callback , We must provide return Stats
 */

class OtherPaymentActiviy extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
