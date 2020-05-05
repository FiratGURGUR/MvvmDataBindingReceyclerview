package com.example.mvvmpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmpattern.adapter.HeroAdapter;
import com.example.mvvmpattern.viewmodel.HeroViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private HeroViewModel myListViewModel;
    private HeroAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        myListViewModel= ViewModelProviders.of(this).get(HeroViewModel.class);


        myListViewModel.getMutableLiveData().observe(this, new Observer<List<HeroViewModel>>() {
            @Override
            public void onChanged(List<HeroViewModel> myListViewModels) {
                adapter=new HeroAdapter(myListViewModels,MainActivity.this);
                recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerview.setAdapter(adapter);
            }
        });


    }
}
