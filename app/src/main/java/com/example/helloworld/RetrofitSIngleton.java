package com.example.helloworld;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitSingleton {
    //declaring retrofit
    //methods and feilds should be static so we can call singleton instead of creating multiple instances of the same object
    private static Retrofit oneInstance;

    //prevents multiple instances
    //static factory method, separates concerns
    static Retrofit getInstance() {
        if (oneInstance != null) {
            return oneInstance;
        }
        oneInstance = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return oneInstance;
    }

    // default constructor
    // explicitly creating a default constructor private
    private RetrofitSingleton() {
    }
}