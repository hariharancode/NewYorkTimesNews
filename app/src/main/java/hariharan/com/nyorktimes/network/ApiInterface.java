package hariharan.com.nyorktimes.network;


import hariharan.com.nyorktimes.data.pojo.MostPopularArticleList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hariharan on 15/07/18.
 */

public  interface ApiInterface {

    @GET("mostpopular/v2/mostviewed/all-sections/7.json?")
    Call<MostPopularArticleList> getMostpopularArticles(@Query("api-key") String api_key);
}
