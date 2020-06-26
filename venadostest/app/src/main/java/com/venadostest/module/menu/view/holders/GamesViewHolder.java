package com.venadostest.module.menu.view.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venadostest.R;

public class GamesViewHolder extends RecyclerView.ViewHolder {
    private  TextView tvDateGame;

    private ImageView imvImageLocal;
    private  TextView tvNameLocal;

    private TextView tvCorner;

    private ImageView imageViewLogoVisitante;
    private  TextView tvNameVisitante;

    public GamesViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDateGame = itemView.findViewById(R.id.tv_fecha);

        imvImageLocal = itemView.findViewById(R.id.imv_logo_local);
        tvNameLocal = itemView.findViewById(R.id.tv_nombre_local);

        tvCorner = itemView.findViewById(R.id.tv_macador);

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

    public TextView getTvCorner() {
        return tvCorner;
    }

    public void setTvCorner(TextView tvCorner) {
        this.tvCorner = tvCorner;
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
}
