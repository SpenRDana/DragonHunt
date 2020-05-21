package com.example.dragonhunt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionViewHolder> {
    private ArrayList<Description> mDescriptions;

    public DescriptionAdapter(ArrayList<Description> descriptions){
        mDescriptions = descriptions;
    }

    @Override
    public DescriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.listitem_layout, parent, false);
        DescriptionViewHolder newViewHolder = new DescriptionViewHolder(rootView);
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(DescriptionViewHolder currentViewHolder, int position) {
        Description currentDescription = mDescriptions.get(position);
        currentViewHolder.bindDescription(currentDescription);
    }

    @Override
    public int getItemCount() {
        return mDescriptions.size();
    }
}
