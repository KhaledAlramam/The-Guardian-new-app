package com.example.chucky.theguardiannewapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    TextView txt;
    public static int loaderID=22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(loaderID,null,this).forceLoad();
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {

        txt=findViewById(R.id.txt);
        txt.setText("sssssssssssssssss");
        txt.setText(s);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
