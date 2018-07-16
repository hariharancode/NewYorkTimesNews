package hariharan.com.nyorktimes.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import hariharan.com.nyorktimes.R;
import hariharan.com.nyorktimes.data.pojo.Article;

/**
 * Created by hariharan on 15/07/18.
 */

public class ArticleWithImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private final ArrayList<Article> articles;
    private final Context context;
    public ImageView iVThumbnail;
    public TextView tVTitle;
    public TextView tVBy;
    public TextView tVDate;

    public ArticleWithImageViewHolder(View view, ArrayList<Article> articles, Context context) {
        super(view);

        this.articles = articles;
        this.context = context;

        iVThumbnail = view.findViewById(R.id.iVLinerArticleView);
        tVTitle = view.findViewById(R.id.tVTitleLinerArticleView);
        tVBy = view.findViewById(R.id.tVByLinearArticleView);
        tVDate = view.findViewById(R.id.tVDateLinearArticleView);

        view.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int position = getLayoutPosition(); // gets item position
        Article article = articles.get(position);
        // We can access the data within the views
        Toast.makeText(context, "Loading article...", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(context, ArticleActivity.class);
        i.putExtra("webUrl", article.getUrl());
        context.startActivity(i);
    }
}
