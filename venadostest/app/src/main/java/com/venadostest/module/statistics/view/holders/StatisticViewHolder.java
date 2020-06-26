package com.venadostest.module.statistics.view.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venadostest.R;

public class StatisticViewHolder extends RecyclerView.ViewHolder{

    private  TextView tvIndex;
    private  TextView tvName;
    private  TextView tvGames;
    private  TextView tvScoreDiff;
    private  TextView tvPoints;
    private  ImageView  imvImage;

    public StatisticViewHolder(@NonNull View view) {
        super(view);
        this.tvIndex = view.findViewById(R.id.tv_Index);
        this.tvName = view.findViewById(R.id.tv_name);
        this.tvGames = view.findViewById(R.id.tv_games);
        this.tvScoreDiff = view.findViewById(R.id.tv_diference_goals);
        this.tvPoints = view.findViewById(R.id.tv_points);
        this.imvImage = view.findViewById(R.id.imv_image);
    }

    public TextView getTvIndex() {
        return tvIndex;
    }

    public void setTvIndex(TextView tvIndex) {
        this.tvIndex = tvIndex;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public TextView getTvGames() {
        return tvGames;
    }

    public void setTvGames(TextView tvGames) {
        this.tvGames = tvGames;
    }

    public TextView getTvScoreDiff() {
        return tvScoreDiff;
    }

    public void setTvScoreDiff(TextView tvScoreDiff) {
        this.tvScoreDiff = tvScoreDiff;
    }

    public TextView getTvPoints() {
        return tvPoints;
    }

    public void setTvPoints(TextView tvPoints) {
        this.tvPoints = tvPoints;
    }

    public ImageView getImvImage() {
        return imvImage;
    }

    public void setImvImage(ImageView imvImage) {
        this.imvImage = imvImage;
    }
}
