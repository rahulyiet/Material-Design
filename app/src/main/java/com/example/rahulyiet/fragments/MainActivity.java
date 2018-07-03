package com.example.rahulyiet.fragments;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity  {
    String headline,news;
    Fragment head_fragment,article_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_article);

        head_fragment=findViewById(R.id.headlinefrag);
        article_fragment=findViewById(R.id.articlefragment);
        String json = null;
        try{

            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
            Log.d("TEST",json);
            JSONObject object = new JSONObject(json);
            headline=object.getString("headline");
            news=object.getString("news");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        HeadlineFragments headlineFragments =new HeadlineFragments();
        Bundle bundle = new Bundle();
        bundle.putString("headline",headline);
        headlineFragments.setArguments(bundle);


        FragmentManager fragmentManager =getSupportFragmentManager();

         fragmentManager.beginTransaction().add(R.id.headlinefrag, headlineFragments).commit();

        head_fragment.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ArticleFragments articleFragments =new ArticleFragments();
                 Bundle bundle=new Bundle();
                 bundle.putString("news",news);
                 articleFragments.setArguments(bundle);
                 FragmentManager fragmentManager=getSupportFragmentManager();
                 fragmentManager.beginTransaction().replace(R.id.articlefragment,articleFragments).commit();

             }
         });




    }
}