package com.example.helloworld.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloworld.Model.Planet;
import com.example.helloworld.R;
import com.example.helloworld.Views.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
    private List<Planet> planetList;
    private View view;

    public PlanetAdapter(@NonNull List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int postition) {

        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.planets_itemview, viewGroup, false);
        return new PlanetViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
planetViewHolder.onBind(planetList.get(position));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}
