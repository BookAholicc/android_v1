package com.bookaholic.userApp.MainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.bookaholic.userApp.Adapter.List.CategoriesAdapter;
import com.bookaholic.userApp.Model.BooksCategory;
import com.bookaholic.userApp.R;
import com.bookaholic.userApp.utils.APIUtils;
import com.bookaholic.userApp.utils.BundleKey;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by nandhu on 29/7/17.
 *
 */

public class DiscoverFragment extends android.support.v4.app.Fragment implements View.OnClickListener, CategoriesAdapter.categoriesCallback {

    SearchView mSearch;
    TextView mExploresText;
    ImageView mComp;
    ImageView mColg;
    ImageView mNf;
    ImageView mFic;
    LinearLayout topCategories;
    RecyclerView mListView;
    FrameLayout mRevealView;
    private Context mContext;
    CategoriesAdapter mAdapter = null;

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.discover_frag, container,false);
        mColg = (ImageView) v.findViewById(R.id.colleges);
        mComp = (ImageView) v.findViewById(R.id.comptetive);
        mNf = (ImageView) v.findViewById(R.id.non_fiction);
        mFic = (ImageView) v.findViewById(R.id.fiction);


        mListView = (RecyclerView) v.findViewById(R.id.categories_list);
        Picasso.with(mContext).load(R.mipmap.ic_launcher_round).transform(new CropCircleTransformation()).into(mColg);
        Picasso.with(mContext).load(R.mipmap.ic_launcher_round).transform(new CropCircleTransformation()).into(mComp);
        Picasso.with(mContext).load(R.mipmap.ic_launcher_round).transform(new CropCircleTransformation()).into(mFic);
        Picasso.with(mContext).load(R.mipmap.ic_launcher_round).transform(new CropCircleTransformation()).into(mNf);

        return  v;
    }


    @Override
    public void onResume() {
        super.onResume();
        mComp.setOnClickListener(this);
        mColg.setOnClickListener(this);
        mNf.setOnClickListener(this);
        mFic.setOnClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mColg.setOnClickListener(null);
        mColg.setOnClickListener(null);
        mNf.setOnClickListener(null);
        mFic.setOnClickListener(null);
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
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comptetive:
                showExamView();
                break;
            case R.id.colleges:
                showCollegesCategory();
                break;
            case R.id.non_fiction:
                showNFBooks();
                break;
            case R.id.fiction:
                showFictionBooks();
            default:
                break;

        }
    }

    private void showFictionBooks() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));


        setAdapterandReveal(mGenList);
    }




    private void showNFBooks() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        setAdapterandReveal(mGenList);
    }

    private void showCollegesCategory() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        setAdapterandReveal(mGenList);
    }

    private void showExamView() {
        List<BooksCategory> mGenList = new ArrayList<>();
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        mGenList.add(new BooksCategory(0,R.drawable.heart_off,"Thriller"));
        setAdapterandReveal(mGenList);
    }


    private void setAdapterandReveal(List<BooksCategory> mList) {

        mAdapter = new CategoriesAdapter(mContext,mList,this);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        mListView.setLayoutManager(layoutManager);
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void categoryClicked(CategoriesAdapter.CategoriesHolder mHolder, BooksCategory mCategory) {
        Intent i = new Intent(getActivity(),BrowseProductsActivity.class);
        i.putExtra(APIUtils.SUB_CATEGORY,mCategory.categoryId);
        startActivity(i);
    }
}