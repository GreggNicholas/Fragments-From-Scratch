package com.example.helloworld.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.squareup.picasso.Picasso;

import static com.example.helloworld.R.id.planetimageview_fragment;
import static com.example.helloworld.R.id.planetname_fragment;
import static com.example.helloworld.R.id.planetnumber_fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String name;
    private int number;
    private String image;

    public MainFragment() {
    }

    public static MainFragment newInstance(String name, int number, String image) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("number", number);
        args.putString("image", image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            name = getArguments().getString("name");
            number = getArguments().getInt("number");
            image = getArguments().getString("image");
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView planetNameView = rootView.findViewById(planetname_fragment);
        TextView planetNumberView = rootView.findViewById(planetnumber_fragment);
        ImageView planetImageView = rootView.findViewById(planetimageview_fragment);


        planetNameView.setText(name);
        planetNumberView.setText(String.valueOf(number));
        Picasso.get()
                .load(image)
                .into(planetImageView);

        return rootView;
    }

}
