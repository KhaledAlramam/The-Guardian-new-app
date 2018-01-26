package com.example.chucky.theguardiannewapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by chucky on 1/26/18.
 */

public class Networkings {

    public static String requestData(URL url){
        String response="";
        try {
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream=connection.getInputStream();

            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";


            response=result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
