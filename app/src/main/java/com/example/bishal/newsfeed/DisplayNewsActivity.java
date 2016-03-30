package com.example.bishal.newsfeed;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class DisplayNewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RssURL newsURL = new RssURL();
    ReadRss readRss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);

        //ActionBar actionBar = getActionBar();
      //  actionBar.setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("newsURL");
        if(url != null && url.equalsIgnoreCase(newsURL.getTop_stories())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getLatest_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getScience_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getSports_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getEntertainment_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getHealth_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getEnergy_industry_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getSecurity_industry_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
        }


    }
}
