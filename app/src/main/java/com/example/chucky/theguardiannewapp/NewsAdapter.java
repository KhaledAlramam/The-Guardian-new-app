package com.example.chucky.theguardiannewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chucky on 1/26/18.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, @NonNull ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        News news=getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_news, parent, false);
        }

        TextView titleView=convertView.findViewById(R.id.news_title);
        TextView dateView=convertView.findViewById(R.id.author);
        TextView sectionView=convertView.findViewById(R.id.section);

        titleView.setText(news.getTitle());
        dateView.setText(news.getDate());
        sectionView.setText(news.getSection());

        return convertView;
    }


}
