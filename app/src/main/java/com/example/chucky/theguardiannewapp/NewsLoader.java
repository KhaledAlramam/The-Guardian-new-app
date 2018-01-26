package com.example.chucky.theguardiannewapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chucky on 1/26/18.
 */

public class NewsLoader extends AsyncTaskLoader<String> {

    public static int loaderID=22;
    public NewsLoader(Context context){
        super(context);
    }

    @Override
    public String loadInBackground() {
        String jsonResponse="";
        URL url;
        try {
             url=new URL("http://content.guardianapis.com/search?q=business&api-key=test&show-references=author");
            jsonResponse=Networkings.requestData(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.e(NewsLoader.class.getSimpleName(),jsonResponse);
        return jsonResponse;
    }
}
