package com.example.helloworld.Views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.DisplayActivity;
import com.example.helloworld.Model.Planet;
import com.example.helloworld.Model.Planets;
import com.example.helloworld.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    private TextView planetNameView;
    private TextView planetNumberView;
    private ImageView planetImageView;
    private Button button;



    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        planetNameView = (TextView) itemView.findViewById(R.id.planetname_itemview);
     planetNumberView = (TextView) itemView.findViewById(R.id.planternumber_itemview);
        planetImageView = (ImageView) itemView.findViewById(R.id.planetimage_itemviee);
    }

    public void onBind(final Planet planet){

        planetNameView.setText(planet.getName());
        planetNumberView.setText(String.valueOf(planet.getNumber()));
        Picasso.get()
                .load(planet.getImages())
                .into(planetImageView);

        button = itemView.findViewById(R.id.intent_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name", planet.getName());
                intent.putExtra("number", planet.getNumber());
                intent.putExtra("image", planet.getImages());

            }
        });

    }



}
