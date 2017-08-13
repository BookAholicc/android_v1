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
 * used in {@link com.bookaholic.userApp.Activity.ExamDetailActivity
 * provided by {@link com.bookaholic.userApp.Adapter.Viewpagers.ExamDetailsAdapter
 *
 *
 * It Prvovides All the Info about the Exam and its Feild
 */

public class ExamInfoFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context mContext;
    private int examId;

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView  = LayoutInflater.from(mContext).inflate(R.layout.exam_info,container,false);



        return mView;
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
        if (getArguments() != null){
            examId = getArguments().getInt(APIUtils.EXAM_CODE);
            getExamDetailsFor(examId);

        }
    }

    private void getExamDetailsFor(int examId) {

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(APIUtils.EXAM_CODE,examId);
            JsonObjectRequest mRequest = new JsonObjectRequest(1,APIUtils.EXAM_DETAILS,jsonObject,this,this);
            AppRequestQueue mAppRequestQueue  = AppRequestQueue.getInstance(mContext);
            mAppRequestQueue.addToRequestQue(mRequest);
        }
        catch (Exception e){

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
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(mContext,"Toast",Toast.LENGTH_LONG).show();

    }
}
