package com.binhlh.hometest.ui.base;

/**
 * Created by BINHLH on 29/08/2018.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
}
