package com.venadostest.module.menu.view.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venadostest.R;

public class SeparatorViewHolder extends RecyclerView.ViewHolder  {
    private TextView tvSeparator;

    public SeparatorViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSeparator = itemView.findViewById(R.id.tv_month);
    }

    public TextView getTvSeparator() {
        return tvSeparator;
    }

    public void setTvSeparator(TextView tvSeparator) {
        this.tvSeparator = tvSeparator;
    }
}
