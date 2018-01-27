package com.example.chucky.theguardiannewapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<News>> {

    public static final String link = "http://content.guardianapis.com/search?q=khaledalramam&api-key=test&show-tags=contributor";
    public static int loaderID = 22;
    ListView listView;
    TextView noCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noCon = findViewById(R.id.no_con);
        if (isNetworkConnected()) {
            noCon.setVisibility(View.GONE);
            getLoaderManager().initLoader(loaderID, null, this).forceLoad();
        } else {
            Toast.makeText(getApplicationContext(), "Check internet connectivity",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public Loader<ArrayList<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(MainActivity.this, link);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<News>> loader, ArrayList<News> newsArrayList) {

        NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsArrayList);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                News currentNews = (News) adapterView.getItemAtPosition(position);

                String webUrl = currentNews.getWebUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(webUrl));
                startActivity(i);
            }
        });


    }

    @Override
    public void onLoaderReset(Loader<ArrayList<News>> loader) {

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {

            return true;

        } else {

            return false;

        }
    }
}
