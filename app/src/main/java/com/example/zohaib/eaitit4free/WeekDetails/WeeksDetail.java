package com.example.zohaib.eaitit4free.WeekDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zohaib.eaitit4free.R;
import com.example.zohaib.eaitit4free.adapters.FoodAdapter;

/**
 * Created by Shami on 1/5/2018.
 */

public class WeeksDetail extends AppCompatActivity {



    FoodAdapter mAdapter;
    RecyclerView mFoodRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_detail);

        mAdapter=new FoodAdapter();
        mFoodRecyclerView=(RecyclerView)findViewById(R.id.itemRecycler);

        mFoodRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mFoodRecyclerView.setAdapter(mAdapter);

    }


}
