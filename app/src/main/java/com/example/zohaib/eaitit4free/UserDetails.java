package com.example.zohaib.eaitit4free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zohaib.eaitit4free.WeekDetails.WeekMain;
import com.example.zohaib.eaitit4free.adapters.OrderAdapter;

public class UserDetails extends AppCompatActivity {


    RecyclerView mlistView;

    OrderAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        mAdapter=new OrderAdapter(new OrderAdapter.onClickListeners() {
            @Override
            public void callBack(int position) {
                Intent weeksmain=new Intent(UserDetails.this, WeekMain.class);
                startActivity(weeksmain);
            }
        });

        mlistView=(RecyclerView)findViewById(R.id.orderlistview);

        mlistView.setLayoutManager(new GridLayoutManager(this,2));
        mlistView.setAdapter(mAdapter);

    }
}
