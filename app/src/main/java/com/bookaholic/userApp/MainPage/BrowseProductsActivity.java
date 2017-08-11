package com.bookaholic.userApp.MainPage;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.BundleKey;

import org.json.JSONObject;

/**
 * Created by nandhu on 8/8/17.
 * The Class Whihc is use to show Activity in a List Or Grid Type Fashion
 */

class BrowseProductsActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {



    RecyclerView mListView;
    int subCategoryId;
    private String TAG = "BP_ACTIVITY";

    public BrowseProductsActivity() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_products_activity);
        mListView = (RecyclerView) findViewById(R.id.b_list);

        if (getIntent() != null) {
            subCategoryId = getIntent().getIntExtra(APIUtils.SUB_CATEGORY,0);
            if (subCategoryId == 0){
                throw new NullPointerException("No Category Id");
            }

            //
            getBooksFor(subCategoryId);
        }
    }

    private void getBooksFor(int subCategoryId) {
        JSONObject jb = new JSONObject();
        try{
            jb.put(APIUtils.SUB_CATEGORY,subCategoryId);
            JsonObjectRequest mReq = new JsonObjectRequest(1,APIUtils.CATEGORY_API,jb,this,this);
        }
        catch (Exception e){
            Log.d(TAG, "getBooksFor: Exception");
        }
    }

    @Override
    public void setTheme(@StyleRes int resid) {
        super.setTheme(resid);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: "+response.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: ");
    }
}
