package com.bookaholic.userApp.Onboarding.UserAboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.MainActivity;
import com.bookaholic.userApp.Model.User;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;
import com.bookaholic.userApp.utils.BundleKey;
import com.bookaholic.userApp.utils.DataStore;
import com.bookaholic.userApp.utils.StringValidator;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by nandhu on 2/6/17.
 * Called after Name has been Obtaiend
 * Reoistration always follows Name, Email & Optional things
 */

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {




    TextInputEditText mPhoneNumber;

    Button mNextButton;
    private Context mContext;




    View mView;
    private String firstName;
    private String email;
    private String password;
    private String TAG = "EMAIL";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_fragment);




        /*get the Arguments from */
        if (getIntent() != null){
            firstName = getIntent().getStringExtra(BundleKey.ARG_FULL_NAME);
            email = getIntent().getStringExtra(BundleKey.ARG_EMAIL_ID);
            password = getIntent().getStringExtra(BundleKey.ARG_PASSWORD);
            Log.d(TAG, "onCreate: Got Intents");


        }
        else{
            throw new NullPointerException("Intent Null");
        }




    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mContext != null) {
            mContext = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mPhoneNumber = (TextInputEditText)findViewById(R.id.number_text);
        mNextButton = (Button)findViewById(R.id.continue_box);
        mNextButton.setOnClickListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }





    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.continue_box){
            //Submit Button has Clicked

            createAccount();
        }
    }


    /** Validate the Fields, if Right then hit the Webservices */
    private void createAccount() {
        String phoneNumber = mPhoneNumber.getText().toString();
        if (StringValidator.checkPhoneNumber(phoneNumber)){
            // Correct Phone number
            newjoin(email,firstName,password,phoneNumber);
        }

    }



    private void newjoin(String emailAddress, String fullname, String password, String phoneNumber) {
        JSONObject mUserObject = new JSONObject();
        try {
            mUserObject.put("fullName",fullname);
            mUserObject.put("phoneNumber",phoneNumber);
            mUserObject.put("emailAddress",emailAddress);
            mUserObject.put("password",password);
            JsonObjectRequest mRequest = new JsonObjectRequest(APIUtils.REGISTER_API,mUserObject,this,this);

            AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
            mRequestQueue.addToRequestQue(mRequest);

        }
        catch (Exception e){
            Log.d(TAG, "newjoin:Exception  ");
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        parseResJson(response);
    }


    private void parseResJson(JSONObject response) {
        try {
            int status  = response.getInt("status");
            if (status == 1){
                //Registered
                DataStore mStore =  DataStore.getStorageInstance(this);
                if (mStore != null){
                    mStore.setUserName(response.getString(APIUtils.FULL_NAME));
                    // setting User Id, From this Point Everything Regarding User Is Tracked
                    mStore.setUserId(response.getInt(APIUtils.USER_ID));
                    mStore.setPhoneNumberTag(response.getString(APIUtils.PHONE_NUMBER));
                    mStore.setEmailId(response.getString(APIUtils.EMAIL));
                    mStore.setIsFirstTime(false);
                    mStore.setLoggedIn(true);
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }


            }
        }
        catch (Exception e){
            Log.d(TAG, "parseJson: Exception "+e.getLocalizedMessage());
            Toast.makeText(this,"Some Error Happened",Toast.LENGTH_SHORT).show();

        }
    }

    private void showPreferncePage() {



    }

    private void AlreadyExists() {

    }

    private String getData(JSONObject response) {

        try {
            return  response.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public interface RegistrationCallback{
        void registered(User u);
        void emailAlreadyExists();
        void phoneAlreadyExists();
        void notRegistered();
    }
}
