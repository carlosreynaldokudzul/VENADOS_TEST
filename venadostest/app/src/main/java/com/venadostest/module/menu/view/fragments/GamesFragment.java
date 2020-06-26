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
import java.util.ArrayList;
import java.util.List;


public class GamesFragment extends Fragment implements GamesServices.GameServiceInterface {


    private  RecyclerView recyclerViewGames;
    private  final String LUEAGE_COPAMX = "Copa MX";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewGames = inflater.inflate(R.layout.fragment_games, container, false);
        recyclerViewGames =(RecyclerView) viewGames.findViewById(R.id.recycler_games_coup);
        recyclerViewGames.setLayoutManager(new LinearLayoutManager((getContext())));

        getGamesServer(getContext(), LUEAGE_COPAMX, new GamesServices.CallBackAction() {
            @Override
            public void onSucess(List<GameModel> list) {
                Log.d("LISTA EXITO FRAG", new Gson().toJson(list));
                GamesAdapter adapter = new GamesAdapter(GamesFragment.this.getContext(), GamesFragment.this.getGameByMonth(list));
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


        return viewGames;
    }

}