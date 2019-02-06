package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.helloworld.Controller.PlanetAdapter;
import com.example.helloworld.Model.Planet;
import com.example.helloworld.Model.Planets;
import com.example.helloworld.Network.PlanetServices;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private List<Planet> planetList = new LinkedList<>();
    private PlanetAdapter planetAdapter;
    private PlanetServices planetServices;
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planetAdapter = new PlanetAdapter(planetList);
        recyclerView = findViewById(R.id.planets_recyclerview);
        recyclerView.setAdapter(planetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        retrofit = RetrofitSingleton.getInstance();
        planetServices = retrofit.create(PlanetServices.class);

        Call<Planets> planetsCall = planetServices.getPlanets();
        planetsCall.enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                Log.d(TAG, "onResponse: " + response.body().getPlanets());
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });


    }
}
