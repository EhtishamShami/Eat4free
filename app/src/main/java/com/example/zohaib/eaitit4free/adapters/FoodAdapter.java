package com.example.zohaib.eaitit4free.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zohaib.eaitit4free.R;

/**
 * Created by Shami on 1/5/2018.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    public FoodAdapter()
    {}



    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);


        return new FoodAdapter.ViewHolder(row);

    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(View itemView) {
            super(itemView);

        }



    }



}

