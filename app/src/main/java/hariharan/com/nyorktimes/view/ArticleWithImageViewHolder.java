package hariharan.com.nyorktimes.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hariharan.com.nyorktimes.R;

/**
 * Created by hariharan on 15/07/18.
 */

public class ArticleWithImageViewHolder extends RecyclerView.ViewHolder{
    public ImageView iVThumbnail;
    public TextView tVTitle;
    public TextView tVBy;
    public TextView tVDate;

    public ArticleWithImageViewHolder(View view) {
        super(view);
        iVThumbnail = view.findViewById(R.id.iVLinerArticleView);
        tVTitle = view.findViewById(R.id.tVTitleLinerArticleView);
        tVBy = view.findViewById(R.id.tVByLinearArticleView);
        tVDate = view.findViewById(R.id.tVDateLinearArticleView);

    }
}
