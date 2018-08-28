package com.binhlh.hometest.data;

/**
 * Created by BINHLH on 28/08/2018.
 */

public interface Callback<T> {
    void onSuccess(T t);

    void onError(String message);
}
