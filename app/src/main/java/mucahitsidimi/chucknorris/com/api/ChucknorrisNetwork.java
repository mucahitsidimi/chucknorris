package mucahitsidimi.chucknorris.com.api;

import java.util.List;

import mucahitsidimi.chucknorris.com.pojo.Joke;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mucahit on 19/02/2017.
 */

public interface ChucknorrisNetwork {

    @GET("jokes/categories")
    Observable<List<String>> getCategories();

    @GET("jokes/random")
    Observable<Joke> getJoke(@Query("category") String categoryName);
}
