package com.example.newsfeedexample;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    public Call<ApiNewsModelClass> getNews(
            @Query("country") String country,
            //@Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    public Call<ApiNewsModelClass> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            //@Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

}
