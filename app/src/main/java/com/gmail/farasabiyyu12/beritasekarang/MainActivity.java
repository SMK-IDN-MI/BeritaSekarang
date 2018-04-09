package com.gmail.farasabiyyu12.beritasekarang;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.farasabiyyu12.beritasekarang.ApiRetrofit.ApiService;
import com.gmail.farasabiyyu12.beritasekarang.ApiRetrofit.InstanceRetrofit;
import com.gmail.farasabiyyu12.beritasekarang.ResponseServer.ArticlesItem;
import com.gmail.farasabiyyu12.beritasekarang.ResponseServer.ResponseReadData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // TODO Swipe Refresh Layout
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                onItemLoad();
            }
            void onItemLoad() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        getData();
    }
    private void getData() {
        ApiService apiService = InstanceRetrofit.getInstance();
        Call<ResponseReadData> call = apiService.response_read_data();
        call.enqueue(new Callback<ResponseReadData>() {
            @Override
            public void onResponse(Call<ResponseReadData> call, Response<ResponseReadData> response) {
                Boolean status = true;
                if (status){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, articlesItems);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseReadData> call, Throwable t) {

            }
        });
    }
}
