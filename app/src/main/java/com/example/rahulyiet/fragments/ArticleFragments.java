package com.example.rahulyiet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragments extends Fragment {

    TextView article;
    String news;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.article,container,false);

        article = v.findViewById(R.id.article);

        Bundle bundle=getArguments();
       news=bundle.getString("news");
       article.setText(news);
        return  v;
    }
}
