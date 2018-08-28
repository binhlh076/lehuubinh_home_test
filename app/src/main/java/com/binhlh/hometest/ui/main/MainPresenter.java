package com.binhlh.hometest.ui.main;

import com.binhlh.hometest.R;
import com.binhlh.hometest.data.Callback;
import com.binhlh.hometest.data.DataManager;
import com.binhlh.hometest.data.model.Keyword;
import com.binhlh.hometest.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by BINHLH on 29/08/2018.
 */

public class MainPresenter extends BasePresenter<MainView> {
    private DataManager dataManager;

    public MainPresenter(MainView view) {
        super(view);
        dataManager = DataManager.getInstance();
    }

    void loadKeywords() {
        getView().showProgress();
        dataManager.getKeyword(new Callback<List<Keyword>>() {
            @Override
            public void onSuccess(List<Keyword> keywords) {

                getView().onLoadKeywordSuccess(keywords);
                getView().hideProgress();
            }

            @Override
            public void onError(String message) {
                getView().onError(message);
                getView().hideProgress();
            }
        });
    }
}
