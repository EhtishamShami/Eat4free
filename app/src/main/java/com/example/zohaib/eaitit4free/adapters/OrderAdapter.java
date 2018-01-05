package com.example.zohaib.eaitit4free.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zohaib.eaitit4free.R;

/**
 * Created by Zohaib on 1/1/2018.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    


    onClickListeners mClickListener;

    public OrderAdapter(onClickListeners mClickListeners)
    {

        mClickListener=mClickListeners;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.resturant_item, parent, false);

        return new ViewHolder(row);
        
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    
    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {


        
        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.callBack(0);
                }
            });
//
//            mViewMore.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mClickListener.callBack(getAdapterPosition());
//                }
//            });

        }
    
    
    
    }


    public interface  onClickListeners
    {
        public void callBack(int position);
    }

    
}
