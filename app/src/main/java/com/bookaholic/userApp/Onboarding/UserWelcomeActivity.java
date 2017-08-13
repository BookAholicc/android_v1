package com.bookaholic.userApp.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bookaholic.userApp.Onboarding.UserAboarding.LoginFragment;
import com.bookaholic.userApp.Onboarding.UserAboarding.PhoneActivity;
import com.bookaholic.userApp.Onboarding.UserAboarding.SignUpNameFragment;
import com.bookaholic.userApp.Onboarding.UserAboarding.UARootFragment;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.BundleKey;


/**
 * Created by nandhu on 2/6/17.
 * The Activity Which comes First Time , or During Profile Page
 */

public  class UserWelcomeActivity extends AppCompatActivity implements UARootFragment.RootCallback, SignUpNameFragment.SignUpCallback {


    private static final String TAG = "BK UA : ";
    UARootFragment mRootFragment;

    // The Face Book Login Button




    private int RC_SIGN_IN = 101;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_aboarding_activity);



        mRootFragment = new UARootFragment();
        mRootFragment.setRootCallback(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder, mRootFragment, "root")
                .setTransition(R.animator.active_raise)
                .commit();


    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ua_frag_holder,new LoginFragment())
                .commit();
    }

    @Override
    public void showSigUpFragment() {
        SignUpNameFragment mFragment = new SignUpNameFragment();

        mFragment.setmCallback(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment)
                .commit();
    }

    @Override
    public void showEmailFragment(String fullName, String email, String pass) {
       Intent i = new Intent(this,PhoneActivity.class);
        Log.d(TAG, "showEmailFragment: Starting Activity");
        i.putExtra(BundleKey.ARG_FULL_NAME,fullName);
        i.putExtra(BundleKey.ARG_EMAIL_ID,email);
        i.putExtra(BundleKey.ARG_PASSWORD,pass);
        startActivity(i);
        finish();

    }

    @Override
    public void noSignUp() {

    }

//
//    @Override
//    public void showLoginFragment() {
//
//        /** Callback is Already Obtained in Fragment in OnAttach()*/
//        LoginFragment mFragment = new LoginFragment();
//
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
//                .commit();
//    }
//
//    @Override
//    public void showSigUpFragment() {
//
//
//
//
//        SignUpNameFragment mFragment = new SignUpNameFragment();
//        mFragment.setmCallback(this);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
//                .commit();
//
//    }
//
//    @Override
//    public void loggedIn(User u) {
//
//    }
//
//    @Override
//    public void notLoggedIn() {
//
//    }
//
//    @Override
//    public void inCorrectLoginDetails() {
//
//    }
//
//    @Override
//    public void showEmailFragment(String firstName, String lastName) {
//
//        Bundle b = new Bundle();
//        b.putString(BundleKey.ARG_FULL_NAME,firstName);
//        b.putString(BundleKey.ARG_LAST_NAME,lastName);
//        PhoneActivity mFragment = new PhoneActivity();
//        mFragment.setmCallback(this);
//        mFragment.setArguments(b);
//
//        //Start the Transaction
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"emailfrag")
//                .commit();
//
//    }
//
//
//    @Override
//    public void registered(User u) {
//        showPrefernceFragment();
//    }

//    private void showPrefernceFragment() {
//        UserPrefFragment mFragment = new UserPrefFragment();
//        mFragment.setmCallback(this);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"preffrag")
//                .commit();
//    }

}
