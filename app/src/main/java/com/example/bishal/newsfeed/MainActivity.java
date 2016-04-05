package com.example.bishal.newsfeed;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RssURL newsURL = new RssURL();
    Intent intent;
    TextView title;
    Toolbar toolbar;

    RelativeLayout top_stories, latest_news, science_news, sports_news, entertainment, health, energy_industry, security_industry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);
        init();
        if(isNetworkAvailable(this)==true){
            top_stories.setOnClickListener(this);
            latest_news.setOnClickListener(this);
            science_news.setOnClickListener(this);
            sports_news.setOnClickListener(this);
            entertainment.setOnClickListener(this);
            health.setOnClickListener(this);
            energy_industry.setOnClickListener(this);
            security_industry.setOnClickListener(this);
        }else{
            showAlertDialogBox();
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_stories:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getTop_stories());
                startActivityForResult(intent, 1);
                break;
            case R.id.latest_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getLatest_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.science_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getScience_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.sports_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getSports_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.entertainment_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getEntertainment_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.health_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getHealth_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.security_industry_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getSecurity_industry_news());
                startActivityForResult(intent, 1);
                break;
            case R.id.energy_industry_news:
                intent = new Intent(getApplicationContext(),DisplayNewsActivity.class);
                intent.putExtra("newsURL", newsURL.getEnergy_industry_news());
                startActivityForResult(intent,1);
                break;

        }
    }
    public void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.title);

        top_stories = (RelativeLayout)findViewById(R.id.top_stories);
        latest_news = (RelativeLayout)findViewById(R.id.latest_news);
        science_news = (RelativeLayout)findViewById(R.id.science_news);
        sports_news = (RelativeLayout)findViewById(R.id.sports_news);
        entertainment = (RelativeLayout)findViewById(R.id.entertainment_news);
        health = (RelativeLayout)findViewById(R.id.health_news);
        security_industry = (RelativeLayout)findViewById(R.id.security_industry_news);
        energy_industry = (RelativeLayout)findViewById(R.id.energy_industry_news);

    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void showAlertDialogBox(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("No Internet Connection");
        alertDialogBuilder.setMessage("Please connect your device to the internet..");
        alertDialogBuilder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing...
            }
        });
        alertDialogBuilder.show();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            title.setText(R.string.news_feed);
        }
    }
}
