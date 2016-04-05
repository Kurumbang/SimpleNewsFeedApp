package com.example.bishal.newsfeed;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bishal on 3/24/2016.
 */
public class ReadRss extends AsyncTask<Void,Void,Void> {

    Context context;
    String address = "";
    ProgressDialog progressDialog;
    URL url;
    ArrayList<FeedItem>feedItems;
    RecyclerView recyclerView;
    public ReadRss(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }
    public void setAddress(String url){
        this.address = url;
    }
    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        MyAdapter adapter = new MyAdapter(context,feedItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new VerticalSpace(10));
    }

    @Override
    protected Void doInBackground(Void... params) {

        processXML(getData());

        return null;
    }

    private void processXML(Document data) {

        if(data != null){
            //arraylist to store all the items..
            feedItems = new ArrayList<>();
            //creat element obj that will store the root element...
            Element root = data.getDocumentElement();

            // item are inside channel and channel tag is the first child of root tag..
            //created new node obj that will store channel...
            Node channel = root.getChildNodes().item(1);
            //now create new nodelist to store all child of item element..
            NodeList items = channel.getChildNodes();
            for(int i = 0; i<items.getLength(); i++){
                //creat node that will store current child...
                Node currentChild = items.item(i);
                if(currentChild.getNodeName().equalsIgnoreCase("item")){
                    //for every item, create FeedItem obj..
                    FeedItem item = new FeedItem();

                    //create new nodelist to store current items lists..
                    NodeList itemChild = currentChild.getChildNodes();
                    for(int j = 0; j < itemChild.getLength(); j++){
                        Node current = itemChild.item(j);
                        if(current.getNodeName().equalsIgnoreCase("title")){
                            item.setTitle(current.getTextContent());
                        }else if(current.getNodeName().equalsIgnoreCase("link")){
                            item.setLink(current.getTextContent());
                        }else if(current.getNodeName().equalsIgnoreCase("description")){
                            item.setDescription(current.getTextContent().replaceAll("<[^>]+?>",""));
                        }else if(current.getNodeName().equalsIgnoreCase("pubDate")){
                            item.setPubDate(current.getTextContent());
                        }else if(current.getNodeName().equalsIgnoreCase("media:thumbnail")){
                           //this will return thumbnail url..
                            String url=current.getAttributes().item(0).getTextContent();
                            item.setThumbnailURL(url);
                        }


                    }
                    feedItems.add(item);


                }
            }

        }

    }

    public Document getData(){

        try{
            url = new URL(address);
            //Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(inputStream);

            return xmlDocument;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
