package com.mars.testexercise.View;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mars.testexercise.R;
import com.mars.testexercise.ViewModel.HomeActivityViewModel;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeActivityViewModel homeActivityViewModel;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;

        recyclerView = findViewById(R.id.recycler_view);

        homeActivityViewModel = ViewModelProviders.of(this).get(HomeActivityViewModel.class);

        homeActivityViewModel.init(context, recyclerView);

    }
}
