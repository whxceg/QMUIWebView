package com.sam.lib.qmui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public RecyclerAdapter() {
        Collections.shuffle(data);
    }

    List<String> data = new ArrayList<>(Arrays.asList("Helps", "Maintain", "Liver",
            "Health", "Function", "Supports", "Healthy", "Fat", "Metabolism",
            "Nuturally", "Bracket", "Refrigerator", "Bathtub", "Wardrobe", "Comb",
            "Apron", "Carpet", "Bolster", "Pillow", "Cushion"));

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popup_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
        }
    }
}
