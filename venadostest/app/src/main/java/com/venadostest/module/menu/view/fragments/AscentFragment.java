package com.venadostest.module.menu.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.venadostest.R;
import com.google.gson.Gson;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.services.GamesServices;
import com.venadostest.module.menu.view.adapters.GamesAdapter;
import java.util.List;

public class AscentFragment extends Fragment implements GamesServices.GameServiceInterface{


    private  RecyclerView recyclerViewGames;
    private final String LUEAGE_ASCENSOMX = "Ascenso MX";

    public AscentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewAscent = inflater.inflate(R.layout.fragment_ascent, container, false);
        recyclerViewGames =(RecyclerView) viewAscent.findViewById(R.id.recycler_games_ascent);
        recyclerViewGames.setLayoutManager(new LinearLayoutManager((getContext())));

        getGamesServer(getContext(), LUEAGE_ASCENSOMX, new GamesServices.CallBackAction() {
            @Override
            public void onSucess(List<GameModel> list) {
                Log.d("LISTA EXITO FRAG", new Gson().toJson(list));
                GamesAdapter adapter = new GamesAdapter(AscentFragment.this.getContext(), AscentFragment.this.getGameByMonth(list));
                recyclerViewGames.setAdapter(adapter);
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


        return viewAscent;
    }
}