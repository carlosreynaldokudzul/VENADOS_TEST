package com.venadostest.module.menu.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venadostest.R;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.models.GameSeparatorModel;
import com.venadostest.module.menu.view.holders.GamesViewHolder;
import com.venadostest.module.menu.view.holders.SeparatorViewHolder;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> itemList;
    private Context context;


    public GamesAdapter ( Context mContext, List<Object> itemList) {
        this.itemList = itemList;
        this.context = mContext;
        Log.d("TAG1", "CONS: "+ itemList.size());

    }
    @Override
    public int getItemViewType(int position) {
        Log.d("TAG1", "ENTRO: "+ position);
        if (itemList.get(position) instanceof GameModel) {
            return 1;
        }else if (itemList.get(position) instanceof GameSeparatorModel) {
            return  2;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View layoutView = null;
        Log.d("TAG1", "ENTRO2 : "+ viewType);
        if(viewType == 1) {
            layoutView = LayoutInflater.from(context).inflate(R.layout.item_games_list, parent, false);
            viewHolder = new GamesViewHolder(layoutView);
        }
        if (viewType == 2) {
            layoutView = LayoutInflater.from(context).inflate(R.layout.item_games_separator, parent, false);
            viewHolder = new SeparatorViewHolder(layoutView);



        }
        Log.d("TAG1", "ENTRO2 : "+ viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GamesViewHolder) {

            //Animation zoomIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            //holder.itemView.startAnimation(zoomIn);

            GameModel gameModel = (GameModel) itemList.get(position);
            ((GamesViewHolder) holder).getTvCorner().setText(gameModel.getHomeScore()+" - "+gameModel.getAwayScore());

        }
        if(holder instanceof SeparatorViewHolder) {

            //Animation zoomIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            //holder.itemView.startAnimation(zoomIn);

            GameSeparatorModel gameSeparatorModel = (GameSeparatorModel) itemList.get(position);
            ((SeparatorViewHolder) holder).getTvSeparator().setText(gameSeparatorModel.getTitle());

        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
