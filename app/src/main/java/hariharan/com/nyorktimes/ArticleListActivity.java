package hariharan.com.nyorktimes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import hariharan.com.nyorktimes.network.ApiClientConfig;
import hariharan.com.nyorktimes.network.ApiInterface;
import hariharan.com.nyorktimes.data.pojo.Article;
import hariharan.com.nyorktimes.data.pojo.MostPopularArticleList;
import hariharan.com.nyorktimes.view.ArticleRecycleViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {

    private RecyclerView articleRecyclerView;
    private ArticleRecycleViewAdapter articleRecycleViewAdapter;
    private ArrayList<Article> articles = new ArrayList<>();
    ApiInterface apiInterface;

    private final static String KEY = "3eb2357455a542a4adc6b0faab35148a";
    public final static String API_KEY = "api-key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        //Basic setuo for Recycler View
        articleRecyclerView = findViewById(R.id.rVArticle);
        articleRecyclerView.setHasFixedSize(true);
        articleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleRecyclerView.setAdapter(articleRecycleViewAdapter = new ArticleRecycleViewAdapter(this,articles));

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

            apiInterface = ApiClientConfig.getClient().create(ApiInterface.class);
            requestArticles();
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

    private void requestArticles() {

        /**
         GET List Resources
         **/
        Call<MostPopularArticleList> callMostPopular = apiInterface.getMostpopularArticles(KEY);
        callMostPopular.enqueue(new Callback<MostPopularArticleList>() {


            @Override
            public void onResponse(Call<MostPopularArticleList> call, Response<MostPopularArticleList> response) {


                Log.d("TAG", response.code() + "");

                MostPopularArticleList mostPopularArticles = response.body();
                articles.addAll(mostPopularArticles.getArticles());
                articleRecycleViewAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MostPopularArticleList> call, Throwable t) {
                Log.d("TAG", "Failure");
                t.printStackTrace();
                call.cancel();
            }
        });
    }
}
