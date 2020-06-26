package com.venadostest.module.menu.view.holders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venadostest.R;

public class GamesViewHolder extends RecyclerView.ViewHolder {
    private ImageButton imbCalendar;
    private  TextView tvDateGame;

    private ImageView imvImageLocal;
    private  TextView tvNameLocal;

    private TextView tvScore;

    private ImageView imageViewLogoVisitante;
    private  TextView tvNameVisitante;

    public GamesViewHolder(@NonNull View itemView) {
        super(itemView);
        imbCalendar = itemView.findViewById(R.id.imb_calendar);
        tvDateGame = itemView.findViewById(R.id.tv_fecha);

        imvImageLocal = itemView.findViewById(R.id.imv_logo_local);
        tvNameLocal = itemView.findViewById(R.id.tv_nombre_local);

        tvScore = itemView.findViewById(R.id.tv_macador);

        imageViewLogoVisitante = itemView.findViewById(R.id.imv_logo_visitante);
        tvNameVisitante = itemView.findViewById(R.id.tv_nombre_visitante);

    }

    public TextView getTvDateGame() {
        return tvDateGame;
    }

    public void setTvDateGame(TextView tvDateGame) {
        this.tvDateGame = tvDateGame;
    }

    public ImageView getImvImageLocal() {
        return imvImageLocal;
    }

    public void setImvImageLocal(ImageView imvImageLocal) {
        this.imvImageLocal = imvImageLocal;
    }

    public TextView getTvNameLocal() {
        return tvNameLocal;
    }

    public void setTvNameLocal(TextView tvNameLocal) {
        this.tvNameLocal = tvNameLocal;
    }

    public TextView getTvScore() {
        return tvScore;
    }

    public void setTvScore(TextView tvScore) {
        this.tvScore = tvScore;
    }

    public ImageView getImageViewLogoVisitante() {
        return imageViewLogoVisitante;
    }

    public void setImageViewLogoVisitante(ImageView imageViewLogoVisitante) {
        this.imageViewLogoVisitante = imageViewLogoVisitante;
    }

    public TextView getTvNameVisitante() {
        return tvNameVisitante;
    }

    public void setTvNameVisitante(TextView tvNameVisitante) {
        this.tvNameVisitante = tvNameVisitante;
    }

    public ImageButton getImbCalendar() {
        return imbCalendar;
    }

    public void setImbCalendar(ImageButton imbCalendar) {
        this.imbCalendar = imbCalendar;
    }
}
