package com.example.chucky.theguardiannewapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by chucky on 1/26/18.
 */

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {

    public static int loaderID = 22;
    public String myStringUrl = "";

    public NewsLoader(Context context, String url) {
        super(context);
        myStringUrl = url;

    }

    @Override
    public ArrayList<News> loadInBackground() {
        ArrayList<News> finalResponse = new ArrayList<>();
        Log.e(NewsLoader.class.getSimpleName(), myStringUrl);
        finalResponse = QueryUtils.fetchData(myStringUrl);


        return finalResponse;
    }
}
