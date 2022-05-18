package com.example.evaluationtask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MoreFragment extends Fragment {

    ArrayList<ProcessesModel> modelArrayList;
    RecyclerView recyclerView;
    ProcessesAdapter adapter;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_more, container, false);

        modelArrayList=new ArrayList<>();
        recyclerView=rootView.findViewById(R.id.processesRv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new ProcessesAdapter(modelArrayList,getContext());
        recyclerView.setAdapter(adapter);



        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
        return rootView;


    }
}