package com.binhlh.hometest.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.binhlh.hometest.R;
import com.binhlh.hometest.data.model.Keyword;
import com.binhlh.hometest.ui.base.OnItemRecyclerClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, OnItemRecyclerClickListener<Keyword> {

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapViews();
        initPresenter();
        initData();
    }

    private void mapViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progressbar);
    }

    private void initPresenter() {
        mPresenter = new MainPresenter(this);
    }

    private void initData() {
        mMainAdapter = new MainAdapter();
        mMainAdapter.setOnItemRecyclerClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mMainAdapter);
        mPresenter.loadKeywords();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadKeywordSuccess(List<Keyword> keyword) {
        mMainAdapter.updateItems(keyword);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(Keyword s, int position) {
        Toast.makeText(this, s.getKeyword(), Toast.LENGTH_SHORT).show();
    }
}
