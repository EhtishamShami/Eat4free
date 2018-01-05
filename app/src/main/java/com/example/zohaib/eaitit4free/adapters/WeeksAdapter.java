package com.example.zohaib.eaitit4free.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zohaib.eaitit4free.R;

/**
 * Created by Shami on 1/5/2018.
 */

public class WeeksAdapter extends RecyclerView.Adapter<WeeksAdapter.ViewHolder> {




    onClickListeners mClickListener;

    public WeeksAdapter(onClickListeners mClickListeners)
    {

        mClickListener=mClickListeners;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_item, parent, false);

        return new ViewHolder(row);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        switch (position)
        {
            case 0:
                holder.mWeek.setText("Week 1");

                break;
            case 1:
                holder.mWeek.setText("Week 2");

                break;
            case 2:
                holder.mWeek.setText("Week 3");

                break;
        }

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView mWeek;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.callBack(0);
                }
            });

            mWeek=(TextView) itemView.findViewById(R.id.week);

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

