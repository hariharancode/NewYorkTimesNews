package hariharan.com.nyorktimes.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hariharan.com.nyorktimes.R;
import hariharan.com.nyorktimes.data.pojo.Article;


/**
 * Created by hariharan on 15/07/18.
 */

public class ArticleRecycleViewAdapter extends RecyclerView.Adapter<ArticleWithImageViewHolder>{

    private static ArrayList<Article> articles;

    public ArticleRecycleViewAdapter(ArrayList<Article> articles){
        this.articles = articles;

    }

    @Override
    public ArticleWithImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linear_article_view_template, parent, false);

        return new ArticleWithImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleWithImageViewHolder holder, int position) {
        //Article article = articles.get(position);
        //holder.iVThumbnail.setImageURI(new Uri.Builder(URarticle.getMedia().get(0).getArticleThumbnailUrl()));

        holder.tVTitle.setText("Supporters of Democratic of Jon Ossof after his ..");
        holder.tVBy.setText("By DAVID LEONHARDT and STUART A THOMPSON");
        holder.tVDate.setText("2017-06-23");

    }

    @Override
    public int getItemCount() {
        return 16;
        //return articles.size();
    }
}
