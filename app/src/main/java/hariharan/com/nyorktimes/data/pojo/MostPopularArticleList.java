package hariharan.com.nyorktimes.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by hariharan on 14/07/18.
 */

public class MostPopularArticleList {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("copyright")
    @Expose
    private String copyright;

    @SerializedName("num_results")
    @Expose
    private Integer numResults;

    @SerializedName("results")
    @Expose
    private ArrayList<Article> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MostPopularArticleList withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public MostPopularArticleList withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public MostPopularArticleList withNumResults(Integer numResults) {
        this.numResults = numResults;
        return this;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public MostPopularArticleList withResults(ArrayList<Article> articles) {
        this.articles = articles;
        return this;
    }
}