package com.example.evaluationtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProcessesActivity extends AppCompatActivity {

    ArrayList<ProcessesModel> modelArrayList;
    RecyclerView recyclerView;
    ProcessesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processes);

        BottomNavigationView bottomAppBar=findViewById(R.id.bottomNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ProcessesFragment()).commit();


        bottomAppBar = findViewById(R.id.bottomNavigation);
        bottomAppBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.processes:
                        fragment = new ProcessesFragment();
                        break;
                    case R.id.report:
                        fragment = new ReportFragment();
                        break;
                    case R.id.more:
                        fragment = new MoreFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                return true;
            }
        });


//        modelArrayList=new ArrayList<>();
//        recyclerView=findViewById(R.id.processesRv);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter=new ProcessesAdapter(modelArrayList,this);
//        recyclerView.setAdapter(adapter);
//
//
//
//        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
//        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
//        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
//        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));
//        modelArrayList.add(new ProcessesModel(R.drawable.sample_process_item,"Send money"));





    }
}