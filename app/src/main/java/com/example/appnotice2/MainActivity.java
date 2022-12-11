package com.example.appnotice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appnotice2.Models.NewsApiResponse;
import com.example.appnotice2.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View recyclerView;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadline(listener, category"general");
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onfetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
            


        }


        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1 ));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapater(adapter);


    }


}