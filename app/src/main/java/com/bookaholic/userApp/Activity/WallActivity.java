package com.bookaholic.userApp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.Adapter.WallAdapter;
import com.bookaholic.userApp.Model.WallItem;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;
import com.bookaholic.userApp.utils.BundleKey;
import com.bookaholic.userApp.utils.CartHandler;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by nandhu on 26/8/17.
 */

public class WallActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {


    int pid;
    private String TAG = "WALL";
    RecyclerView mlistView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wall_activity);
        if (getIntent() != null){
            pid = getIntent().getIntExtra(APIUtils.PID,0);
            if(pid==0){
                throw new NullPointerException("Pid cannot be zero");
            }
            else{
                getWallDataFor(pid);
            }
        }

    }

    private void getWallDataFor(int pid) {
        JSONObject mObject = new JSONObject();
        try{
            mObject.put("pid",pid);
        }
        catch (Exception e){
            Log.d(TAG, "getWallDataFor: ");
        }
        JsonObjectRequest mReq = new JsonObjectRequest(1,APIUtils.GET_WALL,mObject,this,this);
        AppRequestQueue mAppRequestQueue = AppRequestQueue.getInstance(this);
        mAppRequestQueue.addToRequestQue(mReq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Log.d(TAG, "onErrorResponse: ");
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: ");
//        List<WallItem> mWallList = parseResponse(response); // TODO: 26/8/17 Response
        List<WallItem> mList = CartHandler.getInstance(this).getMockWall();
        RecyclerView mlistView = (RecyclerView) findViewById(R.id.wall_list);
        W
        allAdapter mAdapter = new  WallAdapter(mList,getApplicationContext(),this);

    }

    private List<WallItem> parseResponse(JSONObject response) {
        return null;
    }
}
