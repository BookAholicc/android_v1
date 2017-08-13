package com.bookaholic.userApp.MainPage.ExamDetailFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;

import org.json.JSONObject;


/**
 * Created by nandhu on 22/7/17.

 * Provided By Its Adapter
 */

public class ExamBooksFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {


    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.exam_books, container, false);


        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            int examCode = getArguments().getInt(APIUtils.EXAM_CODE);
            getExamBooksFor(examCode);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void getExamBooksFor(int examCode) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(APIUtils.EXAM_CODE, examCode);
            JsonObjectRequest mRequest = new JsonObjectRequest(1, APIUtils.EXAM_BOOKS, jsonObject, this, this);
            AppRequestQueue mAppRequestQueue = AppRequestQueue.getInstance(mContext);
            mAppRequestQueue.addToRequestQue(mRequest);
        } catch (Exception e) {

        }
    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(mContext,"Error ",Toast.LENGTH_LONG).show();
    }

}
