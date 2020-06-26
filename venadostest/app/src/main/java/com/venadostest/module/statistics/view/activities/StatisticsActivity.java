package com.venadostest.module.statistics.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.example.venadostest.R;
import com.google.gson.Gson;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.services.GamesServices;
import com.venadostest.module.menu.view.adapters.GamesAdapter;
import com.venadostest.module.menu.view.fragments.GamesFragment;
import com.venadostest.module.statistics.models.StatisticModel;
import com.venadostest.module.statistics.services.StastisticService;
import com.venadostest.module.statistics.view.adapters.StatisticsAdapter;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity implements StastisticService.StatisticServiceInterface {
    private RecyclerView recyclerStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerStatistics =  findViewById(R.id.recycler_statistic);
        recyclerStatistics.setLayoutManager(new LinearLayoutManager((getApplicationContext())));

        getStatisticServer(getApplicationContext(), new StastisticService.CallBackAction() {
            @Override
            public void onSucess(List<StatisticModel> list) {
                Log.d("LISTA EXITO", new Gson().toJson(list));
                StatisticsAdapter adapter = new StatisticsAdapter(StatisticsActivity.this, list);
                recyclerStatistics.setAdapter(adapter);
            }

            @Override
            public void onError(Object o) {
                Log.d("LISTA ERRROR", new Gson().toJson(o));
            }

            @Override
            public void onEmpty() {
                Log.d("LISTA EMPTY", "VACIA");
            }
        });



    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}