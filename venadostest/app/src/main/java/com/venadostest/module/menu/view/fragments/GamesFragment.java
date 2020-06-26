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
import com.venadostest.module.menu.models.GameSeparatorModel;
import com.venadostest.module.menu.view.adapters.GamesAdapter;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<GameModel> listGamesModel = new ArrayList<>();
    private List<Object> listAllElements = new ArrayList<>();
    private  RecyclerView recyclerViewGames;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GamesFragment() {
        // Required empty public constructor
    }
    public  GamesFragment(List<GameModel>  listGamesModel){
        this.listGamesModel = listGamesModel;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GamesFragment newInstance(String param1, String param2) {
        GamesFragment fragment = new GamesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewGames = inflater.inflate(R.layout.fragment_games, container, false);
        recyclerViewGames =(RecyclerView) viewGames.findViewById(R.id.recycler_games_coup);
        recyclerViewGames.setLayoutManager(new LinearLayoutManager((getContext())));
        fillRecycler();

        GamesAdapter adapter = new GamesAdapter(getContext(),listAllElements);
        recyclerViewGames.setAdapter(adapter);

        return viewGames;
    }
    private boolean valiteDate(Date date, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.MONTH) == month) {
            return true;
        }
        return false;
    }

    private void fillRecycler(){

        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", new Date(), "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", new Date(), "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(false, "Pachuca", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos64x64/11/11.png", new Date(), "Ascenso MX", "https://venados.dacodes.mx/img/usr/fc7c01fa403f4f56aac7d4807bf9b407.jpg",1,1));
        Collections.sort(listGamesModel);
        //new DateFormatSymbols(new Locale("es")).getMonths()[0])

        for (int i = 0;  i < 12; i++) {
            int finalI = i;
            /*List<?> mesLista = listGamesModel.stream()
                    .filter(str -> str.getDatetime().getMonth() == finalI)
                    .collect(Collectors.toList());
*/
            Log.i("TAG1", "ITERACION" +finalI);

            List<?> mesLista = listGamesModel.stream()
                    .filter(str -> valiteDate(str.getDatetime(), finalI))
                    .collect(Collectors.toList());
            if(!mesLista.isEmpty()){
                Log.i("TAG1", "listAll" +finalI);

                GameSeparatorModel gameSeparatorModel = new GameSeparatorModel();
                gameSeparatorModel.setTitle(new DateFormatSymbols(new Locale("es")).getMonths()[i]);

                this.listAllElements.add(gameSeparatorModel);
                listAllElements.addAll(mesLista);
            }


        }





       /* listGamesModel.add(new Separador("ENERO"));
        Enero enero =listGamesModel.stream().filter() element.mes ==1).Sublist();
        listGamesModel.addAll(enero)

        //------------------------------------------------------------------------

        listGamesModel.add(new Separador("ENERO")); listGamesModel.add(new Separador("ENERO"));
        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", "2020-03-14T01:00:00+00:00", "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", "2020-03-14T01:00:00+00:00", "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(false, "Pachuca", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos64x64/11/11.png", "2020-03-14T01:00:00+00:00", "Ascenso MX", "https://venados.dacodes.mx/img/usr/fc7c01fa403f4f56aac7d4807bf9b407.jpg",1,1));
        listGamesModel.add(new Separador("FEBRERO"));
        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", "2020-03-14T01:00:00+00:00", "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(true, "Cafetaleros", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos/11779/11779.png", "2020-03-14T01:00:00+00:00", "Copa MX", "https://venados.dacodes.mx/img/usr/4e2ed67fef4443f691624fd40409eb07.jpg",1,1));
        listGamesModel.add(new GameModel(false, "Pachuca", "https://s3.amazonaws.com/lmxwebsite/docs/archdgtl/AfldDrct/logos64x64/11/11.png", "2020-03-14T01:00:00+00:00", "Ascenso MX", "https://venados.dacodes.mx/img/usr/fc7c01fa403f4f56aac7d4807bf9b407.jpg",1,1));


        //Ordenar por fecha.


        for(int i)


        //agrupar del mes*/

    }


}