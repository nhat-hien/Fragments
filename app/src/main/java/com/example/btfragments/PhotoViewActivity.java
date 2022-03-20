package com.example.btfragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PhotoViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.imageView);

        int posMenu = intent.getIntExtra("PosOfMenu", 0);
        int posItem = intent.getIntExtra("PosOfItem", 0);


        TypedArray images = getResources().obtainTypedArray(R.array.images);
        int contentId = images.getResourceId(posMenu, R.array.flowers);
        String imageURL = getResources().getStringArray(contentId)[posItem];
        images.recycle();

        Picasso.get().load(imageURL).resize(500, 500).into(imageView);
    }
}
