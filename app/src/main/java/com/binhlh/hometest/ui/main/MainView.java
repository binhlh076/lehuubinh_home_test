package com.binhlh.hometest.ui.main;

import com.binhlh.hometest.data.model.Keyword;
import com.binhlh.hometest.ui.base.BaseView;

import java.util.List;

/**
 * Created by BINHLH on 28/08/2018.
 */

public interface MainView extends BaseView {
    void onLoadKeywordSuccess(List<Keyword> keyword);
    void onError(String message);
}
