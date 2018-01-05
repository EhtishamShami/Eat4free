package com.example.zohaib.eaitit4free.WeekDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zohaib.eaitit4free.R;
import com.example.zohaib.eaitit4free.adapters.WeeksAdapter;

/**
 * Created by Shami on 1/5/2018.
 */

public class WeekMain extends AppCompatActivity {


    RecyclerView mlistView;

    WeeksAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        mAdapter=new WeeksAdapter(new WeeksAdapter.onClickListeners() {
            @Override
            public void callBack(int position) {
                Intent weeksDetail=new Intent(WeekMain.this, WeeksDetail.class);
                startActivity(weeksDetail);
            }
        });

        mlistView=(RecyclerView)findViewById(R.id.orderlistview);
        mlistView.setLayoutManager(new GridLayoutManager(this,2));
        mlistView.setAdapter(mAdapter);


    }


}
