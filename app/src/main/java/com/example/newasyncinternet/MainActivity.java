package com.example.newasyncinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask d1;

    static TextView mytext;
    static ImageView myimage;

    ConnectivityManager myConMan;
    NetworkInfo myinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext = (TextView)findViewById(R.id.myResult);
        myimage=(ImageView)findViewById(R.id.myImageResult);

        myConMan=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myinfo = myConMan.getActiveNetworkInfo();
    }
    public void function(View view){
        c1=new ConnectInternetTask(this);
        c1.execute("http://wwww.google.com");
    }
    public void function1(View view) {
        if(myinfo!=null && myinfo.isConnected()){
            d1=new DownloadImageTask();
            d1.execute("https://data1.ibtimes.co.in/cache-img-0-450/en/full/662233/1505535816_pv-sindhu-badminton.jpg");

        }
        else
            Toast.makeText(this,"Internet not connected!!",Toast.LENGTH_SHORT).show();
    }

    }
