package com.example.btfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class PhotoAdapter extends BaseAdapter {

    private Context context;

    private String[] photo_list;

    public PhotoAdapter(@NonNull Context context, @NonNull String[] photo_list) {
        this.photo_list = photo_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photo_list.length;
    }

    @Override
    public Object getItem(int i) {
        return photo_list[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_layout, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Picasso.get().load(photo_list[position]).resize(350, 350).centerCrop().into(imageView);
        return convertView;
    }
}
