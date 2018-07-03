package com.example.rahulyiet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONObject;
import java.io.InputStream;

public class HeadlineFragments extends Fragment  {

    TextView headlines;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v =inflater.inflate(R.layout.headlinelayout,container,false);

       headlines  = v.findViewById(R.id.headlines);
       Bundle bundle =getArguments();
       String headline=bundle.getString("headline");
       headlines.setText(headline);
       return  v;
    }



}
