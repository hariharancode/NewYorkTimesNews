package hariharan.com.nyorktimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    }
}
