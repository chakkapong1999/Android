package com.tni.max.materialmeresource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView sportsTitle = findViewById(R.id.titleDetail);
        TextView sportsSubTitle = findViewById(R.id.subTitleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);

        getWindow().setSharedElementEnterTransition(TransitionInflater
                .from(this).inflateTransition(R.transition.shared_element));

        // Set the text from the Intent extra.
        Intent intent = getIntent();
        sportsTitle.setText(intent.getStringExtra("title"));
        sportsSubTitle.setText(intent.getStringExtra("detail"));
        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(intent.getIntExtra("image_resource",0))
                .into(sportsImage);
    }
}