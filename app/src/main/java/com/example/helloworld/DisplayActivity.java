package com.example.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.helloworld.Fragment.MainFragment;

public class DisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String name = getIntent().getStringExtra("name");
        int num = getIntent().getIntExtra("number", 1);
        String image = getIntent().getStringExtra("image");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_fragment_display, MainFragment.newInstance(name, num, image))
                .addToBackStack("meow")
                .commit();
    }
}
