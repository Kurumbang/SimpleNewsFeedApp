package com.example.bishal.newsfeed;

/**
 * Created by Bishal on 3/29/2016.
 */
public class RssURL {
    String top_stories =  "http://rss.upi.com/news/top_news.rss";
    String latest_news ="http://rss.upi.com/news/news.rss";
    String science_news = "http://rss.upi.com/news/science_news.rss";
    String sports_news ="http://rss.upi.com/news/sports_news.rss";
    String entertainment_news =  "http://rss.upi.com/news/entertainment_news.rss";
    String health_news = "http://rss.upi.com/news/health_news.rss";
    String energy_industry_news = "http://rss.upi.com/news/sn_rw.rss";
    String security_industry_news = "http://rss.upi.com/news/bn_si.rss";

    public String getTop_stories() {
        return top_stories;
    }

    public String getLatest_news() {
        return latest_news;
    }

    public String getScience_news() {
        return science_news;
    }

    public String getSports_news() {
        return sports_news;
    }

    public String getEntertainment_news() {
        return entertainment_news;
    }

    public String getHealth_news() {
        return health_news;
    }

    public String getEnergy_industry_news() {
        return energy_industry_news;
    }

    public String getSecurity_industry_news() {
        return security_industry_news;
    }
}
