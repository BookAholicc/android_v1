package com.bookaholic.userApp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bookaholic.userApp.MainPage.CartFragment;
import com.bookaholic.userApp.MainPage.DiscoverFragment;
import com.bookaholic.userApp.MainPage.HomeFragment;
import com.bookaholic.userApp.MainPage.NotificationFragment;
import com.bookaholic.userApp.MainPage.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    FrameLayout mRoot;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment mFragment = null;

            switch (item.getItemId()) {
                case R.id.th:
                    mFragment = new HomeFragment();
                    break;
                case R.id.td:
                    mFragment = new DiscoverFragment();

                    break;
                case R.id.tn:
                    mFragment = new NotificationFragment();
                    break;
                case R.id.tp:
                    mFragment = new ProfileFragment();
                    break;
                case R.id.tc:
                    mFragment = new CartFragment();
                    break;
            }


            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content,mFragment)
                    .commitAllowingStateLoss();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = (FrameLayout) findViewById(R.id.content);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content,new HomeFragment())
                .commit();
    }

}
