package hariharan.com.nyorktimes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import hariharan.com.nyorktimes.data.pojo.Article;
import hariharan.com.nyorktimes.view.ArticleRecycleViewAdapter;

public class ArticleListActivity extends AppCompatActivity {

    private RecyclerView articleRecyclerView;
    private ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        //Basic setuo for Recycler View
        articleRecyclerView = findViewById(R.id.rVArticle);
        articleRecyclerView.setHasFixedSize(true);
        articleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleRecyclerView.setAdapter(new ArticleRecycleViewAdapter(articles));

        if (!isNetworkAvailable()) {
            Toast.makeText(getApplicationContext(), "Wifi/Mobile data is not available",
                    Toast.LENGTH_LONG).show();
            //TODO launch activity and show failure droid
        } else if (!isOnline()) {
            Toast.makeText(getApplicationContext(), "Please make sure device is online, " +
                            "check wifi and try again!",
                    Toast.LENGTH_LONG).show();
        } else {
            //TODO load data to recycleView using retro
        }
    }

    //Network Availability
    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    //Network available but not Internet
    private boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (InterruptedException | IOException e) { e.printStackTrace(); }
        return false;
    }
}
