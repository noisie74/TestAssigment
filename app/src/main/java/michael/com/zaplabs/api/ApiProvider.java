package michael.com.zaplabs.api;

import java.util.List;

import michael.com.zaplabs.model.Photo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Mikhail on 8/3/16.
 */
public class ApiProvider {

    public static final String API_URL = "http://jsonplaceholder.typicode.com";


    public interface ApiCall {
        @GET("/photos")
        Call<List<Photo>> getImages();
    }

    public static ApiCall create() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiProvider.ApiCall.class);
    }

}
