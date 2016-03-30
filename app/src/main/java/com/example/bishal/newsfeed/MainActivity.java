package com.example.bishal.newsfeed;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RssURL newsURL = new RssURL();
    Intent intent;

    RelativeLayout top_stories, latest_news, science_news, sports_news, entertainment, health, energy_industry, security_industry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //Log.v("TOP NEWS", newsURL.getTop_stories());
        readRss = new ReadRss(this,recyclerView);
        readRss.setAddress(newsURL.getTop_stories());
        readRss.execute();*/

        init();
        top_stories.setOnClickListener(this);
        latest_news.setOnClickListener(this);
        science_news.setOnClickListener(this);
        sports_news.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        health.setOnClickListener(this);
        energy_industry.setOnClickListener(this);
        security_industry.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_stories:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getTop_stories());
                startActivity(intent);
                break;
            case R.id.latest_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getLatest_news());
                startActivity(intent);
                break;
            case R.id.science_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getScience_news());
                startActivity(intent);
                break;
            case R.id.sports_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getSports_news());
                startActivity(intent);
                break;
            case R.id.entertainment_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getEntertainment_news());
                startActivity(intent);
                break;
            case R.id.health_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getHealth_news());
                startActivity(intent);
                break;
            case R.id.security_industry_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getSecurity_industry_news());
                startActivity(intent);
                break;
            case R.id.energy_industry_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL",newsURL.getEnergy_industry_news());
                startActivity(intent);
                break;

        }
    }
    public void init(){
        top_stories = (RelativeLayout)findViewById(R.id.top_stories);
        latest_news = (RelativeLayout)findViewById(R.id.latest_news);
        science_news = (RelativeLayout)findViewById(R.id.science_news);
        sports_news = (RelativeLayout)findViewById(R.id.sports_news);
        entertainment = (RelativeLayout)findViewById(R.id.entertainment_news);
        health = (RelativeLayout)findViewById(R.id.health_news);
        security_industry = (RelativeLayout)findViewById(R.id.security_industry_news);
        energy_industry = (RelativeLayout)findViewById(R.id.energy_industry_news);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }



}
