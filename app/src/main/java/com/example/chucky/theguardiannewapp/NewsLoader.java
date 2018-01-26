package com.example.chucky.theguardiannewapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by chucky on 1/26/18.
 */

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {

    public String myStringUrl="";
    public static int loaderID=22;
    public NewsLoader(Context context,String url){
        super(context);
        myStringUrl=url;
    }

    @Override
    public ArrayList<News> loadInBackground() {
        ArrayList<News> finalResponse=new ArrayList<>();

        finalResponse=QueryUtils.fetchData(myStringUrl);


        return finalResponse;
    }
}
