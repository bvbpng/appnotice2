package com.example.appnotice2;

import com.example.appnotice2.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener <NewsApiResponse>{
     void  onfetchData(List<NewsHeadlines> list, String message);
     void onError(String message);

}
