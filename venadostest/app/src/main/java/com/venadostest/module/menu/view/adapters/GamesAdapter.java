package com.venadostest.module.menu.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.venadostest.R;
import com.squareup.picasso.Picasso;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.models.GameSeparatorModel;
import com.venadostest.module.menu.view.holders.GamesViewHolder;
import com.venadostest.module.menu.view.holders.SeparatorViewHolder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> itemList;
    private Context context;


    public GamesAdapter ( Context mContext, List<Object> itemList) {
        this.itemList = itemList;
        this.context = mContext;

    }
    @Override
    public int getItemViewType(int position) {
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

        if(viewType == 1) {
            layoutView = LayoutInflater.from(context).inflate(R.layout.item_games_list, parent, false);
            viewHolder = new GamesViewHolder(layoutView);
        }
        if (viewType == 2) {
            layoutView = LayoutInflater.from(context).inflate(R.layout.item_games_separator, parent, false);
            viewHolder = new SeparatorViewHolder(layoutView);



        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GamesViewHolder) {

            //Animation zoomIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            //holder.itemView.startAnimation(zoomIn);

            GameModel gameModel = (GameModel) itemList.get(position);
            ((GamesViewHolder) holder).getTvScore().setText(gameModel.getHome_score()+" - "+gameModel.getAway_score());


            ((GamesViewHolder) holder).getTvNameLocal().setText(R.string.venados_fc);
            ((GamesViewHolder)holder).getTvNameVisitante().setText(gameModel.getOpponent());

            Locale spanishLocale=new Locale("es", "ES");
            String day=new SimpleDateFormat("dd EEE",spanishLocale).format(gameModel.getDatetime()).toUpperCase();
            ((GamesViewHolder) holder).getTvDateGame().setText(day);
            ImageView image =  ((GamesViewHolder)holder).getImvImageLocal();
            ImageView opponentImage = ((GamesViewHolder)holder).getImageViewLogoVisitante();

            //Glide.with(context).load(gameModel.getImage()).into(image);
            Glide.with(context).load(gameModel.getOpponent_image()).into(opponentImage);

            ((GamesViewHolder)holder).getImbCalendar().setOnClickListener(v -> Toast.makeText(context,R.string.str_prox,Toast.LENGTH_LONG).show());

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
