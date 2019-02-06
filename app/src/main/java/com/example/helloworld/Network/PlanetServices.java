package com.example.helloworld.Network;

import com.example.helloworld.Model.Planets;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetServices {

    @GET("/JDVila/storybook/master/planets.json")
    Call<Planets> getPlanets();

}
