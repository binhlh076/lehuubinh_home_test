package com.binhlh.hometest.data;

import android.content.Context;
import android.os.AsyncTask;

import com.binhlh.hometest.App;
import com.binhlh.hometest.R;
import com.binhlh.hometest.data.model.Keyword;
import com.binhlh.hometest.util.Constants;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by BINHLH on 28/08/2018.
 */

public class DataManager {
    private static DataManager dataManager;
    private Context context;

    private DataManager(Context context) {
        this.context = context;
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            dataManager = new DataManager(App.getInstance());
        }
        return dataManager;
    }

    public void getKeyword(Callback<List<Keyword>> callback) {
        new GetKeywordTask(callback).execute();
    }

    private class GetKeywordTask extends AsyncTask<Void, Void, List<String>> {
        private Callback callback;

        GetKeywordTask(Callback callback) {
            this.callback = callback;
        }

        @Override
        protected List<String> doInBackground(Void... voids) {
            try {
                InputStream inputStream = new URL(Constants.URL_KEYWORD).openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String json;
                while ((json = bufferedReader.readLine()) != null) {
                    stringBuilder.append(json + "\n");
                }
                json = stringBuilder.toString();
                inputStream.close();
                String[] keywords = new Gson().fromJson(json, String[].class);
                return Arrays.asList(keywords);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            List<Keyword> keywords = new ArrayList<>();

            if (strings != null && !strings.isEmpty()) {
                for (String s :
                        strings) {
                    Keyword keyword = new Keyword();
                    keyword.setKeyword(s);
                    keyword.setColor(ramdomColor());
                    keywords.add(keyword);
                }
            }
            this.callback.onSuccess(keywords);
        }

        private int ramdomColor() {
            int[] color = {R.color.colorBlue, R.color.colorOrange, R.color.colorYellow, R.color.colorGreen, R.color.colorBrown, R.color.colorPurple};
            return color[new Random().nextInt(color.length - 1)];
        }
    }
}

