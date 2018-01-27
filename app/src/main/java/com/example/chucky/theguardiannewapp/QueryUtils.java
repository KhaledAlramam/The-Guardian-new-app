package com.example.chucky.theguardiannewapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chucky on 1/26/18.
 */

public class QueryUtils {

    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static ArrayList<News> fetchData(String stringUrl) {

        URL url = null;
        url = createUrl(stringUrl);
        String jsonResponse = "";
        jsonResponse = requestData(url);
        return jsonFormat(jsonResponse);

    }

    public static String requestData(URL url) {
        String response = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            response = result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static ArrayList<News> jsonFormat(String s) {
        ArrayList<News> arrayList = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(s);
            JSONObject response = data.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);
                String section = obj.getString("sectionName");
                String date = obj.getString("webPublicationDate");
                String title = obj.getString("webTitle");
                String webUrl = obj.getString("webUrl");
                JSONArray tags = obj.getJSONArray("tags");
                JSONObject firsTag = tags.getJSONObject(0);
                String writer = firsTag.getString("webTitle");

                arrayList.add(new News(title, date, section, webUrl, writer));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
