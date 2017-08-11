package com.bookaholic.userApp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;
import com.bookaholic.userApp.utils.BundleKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by nandhu on 20/7/17.
 *
 */

public class OrderPlacedActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
//    @BindView(R.id.op_title_text)
//    WhitenyBooksFont mTitleText;
//    @BindView(R.id.op_image)
//    ImageView mImaage;
//    @BindView(R.id.op_pcount_text)
//    WhitenyBooksFont mPCount;
//    @BindView(R.id.op_div)
//    View opDiv;
//    @BindView(R.id.op_ampunt_text)
//    WhitenyBooksFont mAmount;
//    @BindView(R.id.op_list)
//    RecyclerView mList;
    private String TAG = "ORDERPLACED";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_placed_activity);




        if (getIntent() != null) {
            int orderId = getIntent().getIntExtra(BundleKey.ARG_CATEGORY_ID, 0);
            if (orderId != 0) {
                try {
                    getOrderDetails(orderId);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onCreate: Order id null");
                    throw  new NullPointerException("Order Id is Zero");
                }
            }

        }


    }

    private void getOrderDetails(int orderId) throws JSONException {
        JSONObject mJsonObject = new JSONObject();
        mJsonObject.put(APIUtils.ORDER_ID, orderId);
        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST, APIUtils.ORDER_DETAILS, mJsonObject, this, this);
        AppRequestQueue mREAppRequestQueue = AppRequestQueue.getInstance(this);
        mREAppRequestQueue.addToRequestQue(mRequest);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        mTitleText = (WhitenyBooksFont) findViewById(R.id.op_title_text);
//        mImaage  = (ImageView) findViewById(R.id.op_image);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            int orderId = response.getInt(APIUtils.ORDER_ID);
            int isAccpeted = response.getInt(APIUtils.IS_ACCEPTED);
            double orderLat = response.getDouble(APIUtils.ORDER_LAT);
            double orderLon = response.getDouble(APIUtils.ORDER_LON);
            String orderStatus = response.getString(APIUtils.ORDERS_STATUS);
            JSONArray mProductsArray = response.getJSONArray(APIUtils.PRODUCTS_KEYWORD);
            List<MiniProduct> mList = null;
            for (int i = 0; i < mProductsArray.length(); i++) {
                JSONObject mProduct = mProductsArray.getJSONObject(i);
                String imageURL = mProduct.getString(APIUtils.IMAGE_URL);
                String productName = mProduct.getString(APIUtils.PRODUCT_NAME);
                int pid = mProduct.getInt(APIUtils.PID);
                mList.add(new MiniProduct(productName, imageURL, pid));
            }

            JSONObject mPaymentObject = response.getJSONObject("payment");
            int total = response.getInt("amount");
            Log.d(TAG, "onResponse: GOT total Amount " + total);
            showView(total, mList, orderLat, orderLon, orderId,isAccpeted);
        } catch (Exception e) {
            Log.d(TAG, "Parsing :Error happened " + e.getLocalizedMessage());
        }

    }

//
//            orderId : '',
//                    userId :'',
//                    firstName:'',
//                    lastName:'',
//                    phoneNumber:'',
//
//                    orderLat:'',
//                    orderLon :'',
//
//                    products:[
//
//	],
//            orderStatus:'',
//                    rider:{
//                riderId:'',
//                        riderPhoneNumber:'',
//                        riderName:''
//            },
//            payment:{
//                amount:'',
//                        isCod:'',
//                        codCollected:''
//            },
//            timingEngine:{
//                orderInsertedAt:'',
//                        orderAcceptedAt:'',
//                        riderAcceptedAt:'',
//                        dispatchedAt:'',
//                        deliveredAt:'',
//                        returnDate:''
//            },
//            orderFulfillment:{
//                returnedAt:'',
//                        returnCondition:''

//


    private void showView(int total, List<MiniProduct> mList, double orderLat, double orderLon, int orderId, int isAccpeted) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: ");
    }
}
