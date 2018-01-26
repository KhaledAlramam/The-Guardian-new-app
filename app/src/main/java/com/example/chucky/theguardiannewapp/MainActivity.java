package com.example.chucky.theguardiannewapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<News>> {

    public static int loaderID=22;
    public static final String link="http://content.guardianapis.com/search?q=football&api-key=test&show-references=author";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(loaderID,null,this).forceLoad();
    }






    @Override
    public Loader<ArrayList<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(MainActivity.this,link);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<News>> loader, ArrayList<News> newsArrayList) {

        NewsAdapter adapter=new NewsAdapter(MainActivity.this,newsArrayList);
        listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                News currentNews=(News)adapterView.getItemAtPosition(position);

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
}
