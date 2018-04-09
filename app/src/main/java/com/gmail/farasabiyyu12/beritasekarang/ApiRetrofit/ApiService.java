package com.gmail.farasabiyyu12.beritasekarang.ApiRetrofit;

import com.gmail.farasabiyyu12.beritasekarang.ResponseServer.ResponseReadData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by farasabiyyuhandoko on 01/04/2018.
 */

public interface ApiService {
    
    @GET("top-headlines?country=id&apiKey=d044805809d64bd1896283caa6ea503c")
    Call<ResponseReadData> response_read_data();
}
