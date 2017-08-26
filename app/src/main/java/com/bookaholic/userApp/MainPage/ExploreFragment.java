package com.bookaholic.userApp.MainPage;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.Adapter.List.HorizontalAdapter;
import com.bookaholic.userApp.Model.GenreModel;
import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.OpenSansTextView;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class ExploreFragment extends   android.support.v4.app.Fragment implements Response.ErrorListener, Response.Listener<JSONObject>,HorizontalAdapter.Horizontalcallback {

    private static final String TAGI = "Explore";
    private Context mContext;

    private LinearLayout mAddingLayout;

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
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v  = LayoutInflater.from(mContext).inflate(R.layout.explore_frag, container,false);
        mAddingLayout = (LinearLayout) v.findViewById(R.id.explore_root);






        return  v;
    }



    private void makeExploreRequest() {
        Log.d(TAGI, "making Explore Request");
        JsonObjectRequest mObjectRequest = new JsonObjectRequest(1, APIUtils.HOME_ENDPOINT_GENRE,null,this,this);
        AppRequestQueue mRequestQueue =   AppRequestQueue.getInstance(mContext);
        mRequestQueue.addToRequestQue(mObjectRequest);
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
    public void onResume() {
        super.onResume();
        makeExploreRequest();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {


        Log.d(TAG, "onResponse: "+response.toString());

        int count = 0;

        List<GenreModel> modelist = parseData(response);
        if (modelist == null) {
            throw new NullPointerException("Model Zero");
        }

        for (int i =0; i< modelist.size();i++){

            try {
                Log.d(TAG, "onResponse: Inside Adapter ");

                final View mView = LayoutInflater.from(mContext).inflate(R.layout.explore_card, mAddingLayout, false);
                HorizontalAdapter mAdapter = new HorizontalAdapter(mContext, modelist.get(i).getProductList(), this);
                OpenSansTextView mText = (OpenSansTextView) mView.findViewById(R.id.explore_card_title);
                mText.setText(modelist.get(i).getGenreName());
                RecyclerView mListView = (RecyclerView) mView.findViewById(R.id.explore_list);
                mListView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                mListView.setAdapter(mAdapter);
                mAddingLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mAddingLayout.addView(mView);
                    }
                });
            }
            catch (Exception e){
                Log.d(TAG, "onResponse: Exception in For Loop "+e.getLocalizedMessage());
            }
        }

    }




    private List<GenreModel> parseData(JSONObject response) {


        List<GenreModel> mList = null;
        try {

            JSONArray mGenresArray = response.getJSONArray("genres");
            int genreLength = mGenresArray.length();
            Log.d(TAG, "Intiliszing Genre array with "+genreLength);
            mList = new ArrayList<>(genreLength);

            for (int i =0 ;i < genreLength; i++){
                JSONObject mJsonObject  =  mGenresArray.getJSONObject(i);
                int id = mJsonObject.getInt(APIUtils.GENRE_ID);  // The Genre Id

                String genreName = mJsonObject.getString(APIUtils.GENRE_NAME);  // The Genre Model
                List<MiniProduct> mProductList =
                        parseProduct(mJsonObject.getJSONArray(APIUtils.PRODUCTS_KEYWORD)); // The Products
                mList.add(new GenreModel(genreName,id,mProductList)); // Adding to list

            }
            return mList;
        }
        catch (Exception e){
            Log.d(TAG, "Exception in Genres  "+e.getLocalizedMessage());
            return  null;
        }

    }

    private List<MiniProduct> parseProduct(JSONArray jsonArray) {
        Log.d(TAG, "parseProduct: in Explore "+jsonArray);
        List<MiniProduct> mList = new ArrayList<>();
        try {

            int productsCount = jsonArray.length();
            for (int i = 0;i < productsCount; i++){
                JSONObject mProducts = jsonArray.getJSONObject(i);
                mList.add(new MiniProduct(mProducts.getString(APIUtils.PRODUCT_NAME_1),
                        mProducts.getString(APIUtils.IMAGE_URL),
                        mProducts.getInt(APIUtils.PID)));
            }
            return mList;
        }
        catch (Exception e){

            Log.d(TAG, "Exception in Parsing Genre "+e.getLocalizedMessage());
            return  null;
        }
    }

    @Override
    public void productClicked(int pid) {

    }
}