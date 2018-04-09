package com.gmail.farasabiyyu12.beritasekarang.ApiRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by farasabiyyuhandoko on 01/04/2018.
 */

public class InstanceRetrofit {
    //Declare the URLWeb
    public static final String WebURL = "https://newsapi.org/v2/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(WebURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
