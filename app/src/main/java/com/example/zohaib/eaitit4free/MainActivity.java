package com.example.zohaib.eaitit4free;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<UserOrder> arraylist;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=getIntent();
//        username=intent.getStringExtra("username");
//        try {
//            Bundle bundle = getIntent().getExtras();
//             arraylist = bundle.getParcelableArrayList("ordrlist");
//
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(this,"No Order Details Found!",Toast.LENGTH_LONG).show();
//        }



    }

    public void openContactUs(View view)
    {
        String url = "http://www.eat-it-4free.co.uk/cms/contact-us";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void openWebsite(View view)
    {
        String url = "http://www.eat-it-4free.co.uk";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void goToLogin(View view)
    {
        Intent intent=new Intent(MainActivity.this,UserDetails.class);
//        if(arraylist!=null) {
//            Bundle bundle = new Bundle();
//            bundle.putParcelableArrayList("ordrlist", arraylist);
//            intent.putExtras(bundle);
//        }
//        intent.putExtra("username",username);

        startActivity(intent);

    }
}
