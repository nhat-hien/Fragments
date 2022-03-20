package com.example.btfragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class ContentFrag extends Fragment {
GridView gridView;
    int posMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.findViewById(R.id.gridview);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), PhotoViewActivity.class);
                intent.putExtra("PosOfMenu", posMenu);
                intent.putExtra("PosOfItem", i);
                startActivity(intent);
            }
        });

        updateContent(0);
        return view;
    }

    public void updateContent(int position){
        posMenu = position;
        TypedArray images = getResources().obtainTypedArray(R.array.images);
        int contentId = images.getResourceId(position, R.array.flowers);
        gridView.setAdapter(new PhotoAdapter(getActivity(), getResources().getStringArray(contentId)));
        images.recycle();
    }
}