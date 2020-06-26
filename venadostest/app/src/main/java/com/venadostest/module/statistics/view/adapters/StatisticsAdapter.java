package com.venadostest.module.statistics.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.venadostest.R;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.view.holders.GamesViewHolder;
import com.venadostest.module.statistics.models.StatisticModel;
import com.venadostest.module.statistics.view.holders.StatisticViewHolder;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<StatisticModel> itemList;
    private Context context;

    public StatisticsAdapter(Context mContext, List<StatisticModel> itemList){
        this.itemList = itemList;
        this.context = mContext;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View layoutView = null;

        layoutView = LayoutInflater.from(context).inflate(R.layout.item_statistic_list, parent, false);
        viewHolder = new StatisticViewHolder(layoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StatisticModel statisticModel = (StatisticModel) itemList.get(position);
        ((StatisticViewHolder) holder).getTvIndex().setText(String.valueOf(statisticModel.getPosition()));
        ((StatisticViewHolder) holder).getTvName().setText(statisticModel.getTeam());
        ((StatisticViewHolder) holder).getTvGames().setText(String.valueOf(statisticModel.getGames()));
        ((StatisticViewHolder) holder).getTvScoreDiff().setText(String.valueOf(statisticModel.getScore_diff()));
        ((StatisticViewHolder) holder).getTvPoints().setText(String.valueOf(statisticModel.getPoints()));

        ImageView imageTeam = ((StatisticViewHolder)holder).getImvImage();

        //Glide.with(context).load(gameModel.getImage()).into(image);
        Glide.with(context).load(statisticModel.getImage()).into(imageTeam);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
