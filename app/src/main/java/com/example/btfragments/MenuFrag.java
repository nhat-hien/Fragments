package com.example.btfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuFrag extends Fragment {
    String [] menus = {"Flowers", "Animals", "Foods"};
    ListView list;
    private AdapterView.OnItemClickListener onClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            itemfragment.onMenuItemClick(i);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        list = view.findViewById(R.id.list);
        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.menu_layout, (new ArrayList<String>(Arrays.asList(menus))));
        list.setAdapter(listadapter);
        list.setOnItemClickListener(onClick);
        return view;
    }


    public interface IFragmentClickListener{
        public void onMenuItemClick(int position);
    }

    IFragmentClickListener itemfragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{ itemfragment = (IFragmentClickListener) context;}
        catch (ClassCastException e){ e.printStackTrace();}
    }
}