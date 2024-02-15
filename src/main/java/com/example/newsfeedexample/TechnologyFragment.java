package com.example.newsfeedexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {
    String apiKey = "121a6637ca934bf495048e4e17d15e30";

    ArrayList<NewsItemModelClass> modelClassArrayList;
    NewsItemAdapter adapter;
    String country="in";
    private RecyclerView recyclerViewofTechnology;
    private String category="technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_fragment, null);

        recyclerViewofTechnology=view.findViewById(R.id.recyclerviewoftechnology);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsItemAdapter(getContext(), modelClassArrayList);
        recyclerViewofTechnology.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
       ApiUtilities.getApiInterface().getNews(country,apiKey).enqueue(new Callback<ApiNewsModelClass>() {
            @Override
            public void onResponse(Call<ApiNewsModelClass> call, Response<ApiNewsModelClass> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiNewsModelClass> call, Throwable t) {

            }
        });
    }
}
