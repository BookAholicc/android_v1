package com.bookaholic.userApp.ViewProduct;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholic.userApp.Model.MiniProduct;
import com.bookaholic.userApp.Model.Product;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.UI.WhitenyBooksFont;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.AppRequestQueue;
import com.bookaholic.userApp.utils.BundleKey;
import com.bookaholic.userApp.utils.CartHandler;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nandhu on 26/7/17.
 * Provide Id
 */

public class ProductShowingActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject>, OnLikeListener, RadioGroup.OnCheckedChangeListener {

//    @BindView(R.id.vp_image) ImageView mImage;
//    @BindView(R.id.vp_top_holder)
//    FrameLayout vpTopHolder;
//    @BindView(R.id.vp_b_title)
//    WhitenyBooksFont mTitle;


//    @BindView(R.id.tsLikesCounter)



//
//    TextSwitcher mPrice;
////    @BindView(R.id.vp_author_name)
//    WhitenyBooksFont mAuthorName;
//    @BindView(R.id.vp_b_one_liner)
//    WhitenyBooksFont mOneLiner;
//    @BindView(R.id.vp_b_rg)
//    RadioGroup mRadioGroup;
//    @BindView(R.id.v_b_pc)
//    WhitenyBooksFont vBPc;
//    @BindView(R.id.vp_b_div)
//    View vpBDiv;
//    @BindView(R.id.genre_image)
//    ImageView mGenImage;
//    @BindView(R.id.gen_name)
//    WhitenyBooksFont mGenName;
//    @BindView(R.id.vp_b_like_buton)
//    LikeButton mLike;
//    @BindView(R.id.like_count)
//    WhitenyBooksFont mLikeCount;
//    @BindView(R.id.linearLayout)
//    LinearLayout linearLayout;
//    @BindView(R.id.about_book_text)
//    TextView mAbout;
//    @BindView(R.id.about_arrow)
//    ImageView mAboutArrow;
//    @BindView(R.id.about_book_container)
//    RelativeLayout mAboutContainer;
//    @BindView(R.id.similar_book_text)
//    WhitenyBooksFont similarBookText;
//    @BindView(R.id.s_1)
//    CircleImageView s1;
//    @BindView(R.id.s_2)
//    CircleImageView s2;
//    @BindView(R.id.s_3)
//    CircleImageView s3;
//    @BindView(R.id.s_4)
//    CircleImageView s4;
//    @BindView(R.id.s_5)
//    CircleImageView s5;
//    @BindView(R.id.s_6)
//    CircleImageView s6;
//    @BindView(R.id.s_7)
//    CircleImageView s7;
//
//    private Unbinder unbinder;

    private String TAG = "PRODUCT_VIEW";
    private Product p;

    RadioButton sDays;
    int price7;
    RadioButton fDays;
    int price15;
    RadioButton tDays;
    int price30;
    RadioGroup priceGroup;
    TextSwitcher mPriceSwitch;
    WhitenyBooksFont mPagesDura;
    RelativeLayout mGenreBox;
    RelativeLayout CopiesBox;
    LikeButton mLikeButton;
    WhitenyBooksFont mLieCount;
    ImageView im ;
    int pid = 0;
    String pname;
    String ol;
    String an;
    String imageURL;

    Toolbar mToolbar;
    ImageView s1;
    ImageView s2;
    ImageView s3;
    ImageView s4;
    ImageView s5;
    ImageView s6;
    ImageView s7;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_show_activity);
        Log.d(TAG, "onCreate: ");
        supportPostponeEnterTransition();

        pid = getIntent().getIntExtra("pid",0);
        String trans = getIntent().getStringExtra(BundleKey.TRANS_NAME);
        final ImageView im = (ImageView) findViewById(R.id.backdrop);
        im.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        im.getViewTreeObserver().removeOnPreDrawListener(this);
                        supportStartPostponedEnterTransition();
                        return true;
                    }
                }
        );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            im.setTransitionName(trans);
            Log.d(TAG, "onCreate: Setted Up transition Name");
        }
        if (pid != 0){
             pname = getIntent().getStringExtra(APIUtils.PRODUCT_NAME);
             ol = getIntent().getStringExtra(APIUtils.ONE_LINER);
             an= getIntent().getStringExtra(APIUtils.AUTHOR_NAME);
            price7 = getIntent().getIntExtra(BundleKey.PR7,0);
            imageURL = getIntent().getStringExtra(APIUtils.IMAGE_URL);
            price15= getIntent().getIntExtra(APIUtils.PRICE15,0);
            price30= getIntent().getIntExtra(APIUtils.PRICE30,0);


            // start Views
                                                                                                                                                                                      WhitenyBooksFont pName = (WhitenyBooksFont) findViewById(R.id.vp_b_title);
            WhitenyBooksFont mA = (WhitenyBooksFont) findViewById(R.id.vp_author_name);
            WhitenyBooksFont oll  = (WhitenyBooksFont)findViewById(R.id.vp_b_one_liner);
            mLikeButton = (LikeButton) findViewById(R.id.vp_b_like_buton);
            mLikeButton.setOnLikeListener(this);
            sDays = (RadioButton) findViewById(R.id.s_price);
            fDays = (RadioButton) findViewById(R.id.f_price);
            tDays = (RadioButton) findViewById(R.id.t_price);
            RadioGroup mPrice = (RadioGroup) findViewById(R.id.price_radio_g);
            mPrice.setOnCheckedChangeListener(this);

            mPriceSwitch = (TextSwitcher) findViewById(R.id.tsLikesCounter);
            mPriceSwitch.setText(""+price7);


            ImageView addtocart = (ImageView) findViewById(R.id.vp_atc);
            addtocart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addProductToCart();
                }
            });
            supportPostponeEnterTransition();






            Picasso.with(this)
                    .load(imageURL)
                    .fit()
                    .noFade()
                    .centerCrop()
                    .into(im, new Callback() {
                        @Override
                        public void onSuccess() {
                            supportStartPostponedEnterTransition();
                        }

                        @Override
                        public void onError() {
                            supportStartPostponedEnterTransition();
                        }
                    });

//

            pName.setText(pname);
            oll.setText(ol);
            mA.setText(an);
            mToolbar = (Toolbar)findViewById(R.id.vp_toolbar);
            setSupportActionBar(mToolbar);
            if (getSupportActionBar() != null){
                ActionBar ab = getSupportActionBar();
                ab.setDisplayHomeAsUpEnabled(true);
                ab.setDisplayShowHomeEnabled(true);
            }


            //Setting Views

        }
        else{
            // Pid is Zero
            throw new NullPointerException("Pid is Zero");
        }



    }

    private void addProductToCart() {
        MiniProduct p = new MiniProduct(pname,imageURL,pid,price7);
        CartHandler.getInstance(this).addProductToCart(p);


    }

    private void getDataFor(int pid) {
        Log.d(TAG, "Making Request: ");
        JSONObject j = new JSONObject();
        try {
            j.put(APIUtils.PID, j);
            JsonObjectRequest m = new JsonObjectRequest(1, APIUtils.HOME_ENDPOINT_VIEW_PRODUCT, j, this, this);
            AppRequestQueue.getInstance(this).addToRequestQue(m);
        }
        catch (Exception e){
            Log.d("Exception","JSON");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");


        s1 = (ImageView)findViewById(R.id.s_1);
        s2 = (ImageView)findViewById(R.id.s_2);
        s3 = (ImageView)findViewById(R.id.s_3);
        s4 = (ImageView)findViewById(R.id.s_4);
        s5 = (ImageView)findViewById(R.id.s_5);
        s6 = (ImageView)findViewById(R.id.s_6);
        s7 = (ImageView)findViewById(R.id.s_7);

//        getDataFor(pid);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");

        setUpViews();
    }

    private void setUpViews() {
        TextSwitcher mSwitcher;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: ");
    }



    private List<MiniProduct> mList;
    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: ");
        try {
            mList = new ArrayList<>();
            JSONArray m = response.getJSONArray("similar");
            for (int i =0; i< m.length(); i++){
                // we need the URl's and Need it to set it to s1,s2
                JSONObject m1 = m.getJSONObject(i);
                mList.add(new MiniProduct(m1.getString(APIUtils.PRODUCT_NAME),m1.getString(APIUtils.IMAGE_URL),m1.getInt(APIUtils.PID)));
                updateImage(i,m1.getString(APIUtils.IMAGE_URL));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateImage(int i, String string) {

        Log.d(TAG, "updateImage: Called ");

        switch (i){
            case 0:
                Picasso.with(this)
                        .load(string)
                        .into(s1);
                break;
            case 1:
                Picasso.with(this)
                        .load(string)
                        .into(s2);
                break;
            case 2:
                Picasso.with(this)
                        .load(string)
                        .into(s3);
                break;
            case 3:
                Picasso.with(this)
                        .load(string)
                        .into(s4);
                break;
            case 4:
                Picasso.with(this)
                        .load(string)
                        .into(s5);
                break;
            case 5:
                Picasso.with(this)
                        .load(string)
                        .into(s6);
                break;
            case 6:
                Picasso.with(this)
                        .load(string)
                        .into(s7);
                break;
            default:
                break;
        }
    }


    @Override
    public void liked(LikeButton likeButton) {

    }

    @Override
    public void unLiked(LikeButton likeButton) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (group.getId() == R.id.price_radio_g){
            switch (checkedId){
                case R.id.s_price:
                    mPriceSwitch.setText(""+price7);

                    break;
                case R.id.f_price:
                    mPriceSwitch.setText(""+price15);
                    break;
                case R.id.t_price:
                    mPriceSwitch.setText(""+price30);
                    break;
                default:
                    break;
            }
        }
    }
}