package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.Model.EntryViewModel;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.ViewProduct.ProductShowingActivity;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class EntryGridFragment extends  BaseFragment implements Response.Listener<JSONObject>, Response.ErrorListener,EntryFeedAdapter.EntryItemCallbacks {

    private Context mContext;
    private String TAG = "SUBENTRY";
    private RecyclerView mList;
    FrameLayout mRoot;

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
        Log.d(TAG, "onCreate:User Id "+getA());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.entry_grid, container,false);
        mRoot = (FrameLayout) v.findViewById(R.id.e_root);
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
        Log.d(TAG, "onStart: ");
        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST, APIUtils.HOME_API,null,this,this);
        AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
        if (mRequestQueue != null){
            Log.d(TAG, "onStart: adding");
            mRequestQueue.addToRequestQue(mRequest);

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

    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: "+response.toString());
        try {
            JSONArray mProductsArray = response.getJSONArray("products");
            JSONArray mComboArray  = response.getJSONArray("combos");

            List<EntryViewModel> mProductsList = null;
            List<EntryViewModel> mCombosList = null;
            try {

                mProductsList = getProductListFromJson(mProductsArray);
//                mCombosList = getComboListFromJson(mComboArray);

                setAdapter(mProductsList);
            }
            catch (Exception e){
                Log.d(TAG, "onResponse: Exception in parsing new arrivals "+e.getLocalizedMessage());


            }



        }
        catch (Exception e){


            Log.d(TAG, "onResponse: Exception in Parsing home "+e.getLocalizedMessage());
        }
    }

    private void setAdapter(List<EntryViewModel> mProductsList) {
        Log.d(TAG, "setAdapter:size  "+mProductsList.size());
        try {
            View list = null;
            if (mRoot != null){
                mRoot.removeAllViews();
                list = View.inflate(mContext,R.layout.list,mRoot);
            }

            mList = (RecyclerView) list.findViewById(R.id.list);
            final EntryFeedAdapter  mAdapter = new EntryFeedAdapter(mProductsList,getActivity(),this);

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
            mList.setLayoutManager(layoutManager);
            mList.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }
        catch (Exception e){
            Log.d(TAG, "setAdapter: Excetpion");
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (mRoot != null){
            View mErrorLayout = View.inflate(mContext,R.layout.error,mRoot);
        }
    }

    private List<EntryViewModel> getComboListFromJson(JSONArray mComboArray) {




        //Make Sure not more than 7
        int productCount = mComboArray.length();

        List<EntryViewModel> mList = new ArrayList<>(productCount);
        try {
            for (int i = 0; i < productCount; i++) {



                // Get the Oject Turn It to String
                JSONObject pObj = null;
                pObj = mComboArray.getJSONObject(i);


                if (pObj != null){

                    //Got the Object , get String Push it to List
                    try {

//                        mList.add(new EntryViewModel(pObj.getString(APIUtils.C_IMAGE_URL), pObj.getInt(APIUtils.OUR_PRICE), pObj.getInt(APIUtils.CID),true));
                    }
                    catch (Exception e){
                        Log.d(TAG, "Exception in getting JSON from Combo "+e.getLocalizedMessage());
                        throw  new NullPointerException("Exception iN Parsing");
                    }
                }
                else{
                    Log.d(TAG, "getComboListFromJson: Product Null at Index "+i);

                }



            }
            return mList;
        }
        catch (Exception e) {

            Log.d(TAG, "getProductListFromJson: "+e.getLocalizedMessage());
            throw  new NullPointerException("Exception iN Parsing");
        }

    }

    /*Parse the Product Add Gson Here Later */
    private List<EntryViewModel> getProductListFromJson(JSONArray mProductsArray) {
        int productCount = mProductsArray.length();
        List<EntryViewModel> mList = new ArrayList<>(productCount);
        try {
            for (int i = 0; i < 18; i++) {
                if (mProductsArray.getJSONObject(i) != null) {
                    JSONObject pObj = null;
                    pObj = mProductsArray.getJSONObject(i);
                    if (pObj != null){
                        mList.add(new EntryViewModel(
                                pObj.getInt(APIUtils.PID),
                                pObj.getString(APIUtils.PRODUCT_NAME),
                                pObj.getString(APIUtils.ONE_LINER),
                                pObj.getString(APIUtils.AUTHOR_NAME),
                                pObj.getString(APIUtils.PUBLISHER_NAME),
                                pObj.getString(APIUtils.BOOK_SUMMARY),
                                pObj.getString(APIUtils.IMAGE_URL),
                                pObj.getString(APIUtils.BASE_CATEGORY),
                                pObj.getString(APIUtils.SUB_CATEGORY),
                                pObj.getString(APIUtils.LANGUAGE),
                                pObj.getInt(APIUtils.MRP),
                                pObj.getInt(APIUtils.IS_TOP_RATED),
                                pObj.getInt(APIUtils.IS_BEST_SELLER),
                                pObj.getInt(APIUtils.QUANTITY),
                                pObj.getInt(APIUtils.ISBN),
                                pObj.getInt(APIUtils.PAGES),
                                pObj.getInt(APIUtils.RD),
                                pObj.getInt(APIUtils.PRICE7),
                                pObj.getInt(APIUtils.PRICE15),
                                pObj.getInt(APIUtils.PRICE30),false));
                    }
                    else{
                        // Object is Empty
                    }


                }
            }
            //Product Has Been Obtained and Put in List
            return mList;
        }
        catch (Exception e) {
            Log.d(TAG, "getProductListFromJson: "+e.getMessage());


            return null;


        }

    }


    @Override
    public void addToCart() {

    }

    @Override
    public void addToWishlist() {

    }

    @Override
    public void showProduct(EntryViewModel m, RecyclerView.ViewHolder holder) {
        Log.d(TAG, "showing Product "+m.pid);
        ImageView imtoTra = (ImageView) holder.itemView.findViewById(R.id.e_i_image);
        Intent i = new Intent(mContext,ProductShowingActivity.class);
        i.putExtra("pid",m.pid);
        i.putExtra(APIUtils.PRODUCT_NAME,m.productName);
        i.putExtra(APIUtils.ONE_LINER,m.oneLiner);
        i.putExtra(APIUtils.AUTHOR_NAME,m.authorName);
        i.putExtra(APIUtils.IMAGE_URL,m.imageURL);
        i.putExtra(APIUtils.PRICE7,m.price7);
        i.putExtra(APIUtils.PRICE15,m.price15);
        i.putExtra(APIUtils.PRICE30,m.price30);
        ActivityOptionsCompat options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(getActivity(), (View)imtoTra,imtoTra.getTransitionName());
            getActivity().startActivity(i, options.toBundle());
        }


    }
}