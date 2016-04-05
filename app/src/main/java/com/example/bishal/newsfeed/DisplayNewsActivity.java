package com.example.bishal.newsfeed;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DisplayNewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RssURL newsURL = new RssURL();
    ReadRss readRss;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.title);
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
            title.setText(R.string.top_stories);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getLatest_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.latest_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getScience_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.science_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getSports_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.sports_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getEntertainment_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.entertainment_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getHealth_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.health_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getEnergy_industry_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.energy_news);
        }
        if(url != null && url.equalsIgnoreCase(newsURL.getSecurity_industry_news())){
            readRss = new ReadRss(this,recyclerView);
            readRss.setAddress(url);
            readRss.execute();
            title.setText(R.string.security_news);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent();
        setResult(Activity.RESULT_CANCELED,intent);
        finish();//finishing activity
    }
}
