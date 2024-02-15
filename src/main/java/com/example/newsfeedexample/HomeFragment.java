package com.example.newsfeedexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kotlinx.coroutines.GlobalScope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HomeFragment extends Fragment {
    String apiKey = "121a6637ca934bf495048e4e17d15e30";

    ArrayList<NewsItemModelClass> modelClassArrayList;
    NewsItemAdapter adapter;
    String country="in";
    private RecyclerView recyclerViewofHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);

        recyclerViewofHome=view.findViewById(R.id.recyclerviewofhome);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsItemAdapter(getContext(), modelClassArrayList);
        recyclerViewofHome.setAdapter(adapter);
        //try {
        Log.d("DEBUG", "before findnews");
        findNews();
        Log.d("DEBUG", "after findnews");
        //} catch (Exception e){
        //    e.printStackTrace();
        //}


        return view;
    }

    private void findNews() {
        Log.d("DEBUG", "befroe getapiinterface");
        ApiUtilities.getApiInterface().getNews(country, apiKey).enqueue(new Callback<ApiNewsModelClass>() {
            @Override
            public void onResponse(Call<ApiNewsModelClass> call, Response<ApiNewsModelClass> response) {
                Log.d ("DEBUG", "inside getapiinterface on response");
                if (response.isSuccessful()) {
                    Log.d ("DEBUG", "inside getapiinterface on response is success");
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiNewsModelClass> call, Throwable t) {
                Log.d ("DEBUG", "inside getapiinterface on failure");
            }
        });
    }
}
