package hariharan.com.nyorktimes.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import hariharan.com.nyorktimes.R;
import hariharan.com.nyorktimes.data.pojo.Article;


/**
 * Created by hariharan on 15/07/18.
 */

public class ArticleRecycleViewAdapter extends RecyclerView.Adapter<ArticleWithImageViewHolder>{

    private static ArrayList<Article> articles;
    private final Context context;

    public ArticleRecycleViewAdapter(Context context,ArrayList<Article> articles){

        this.context = context;
        this.articles = articles;

    }

    @Override
    public ArticleWithImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linear_article_view_template, parent, false);

        return new ArticleWithImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleWithImageViewHolder articleViewholder, int position) {

        Article article = articles.get(position);

        articleViewholder.tVTitle.setText(article.getTitle());
        articleViewholder.tVBy.setText(article.getByline());
        articleViewholder.tVDate.setText(article.getPublishedDate());

        //TODO retrive images to show thumbnail.Use Glide or Picasso

        if (!TextUtils.isEmpty(article.getMedia().get(0).getArticleThumbnailUrl())) {
            Glide.with(context).load(article.getMedia().get(0).getArticleThumbnailUrl())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(articleViewholder.iVThumbnail);
        }



    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
