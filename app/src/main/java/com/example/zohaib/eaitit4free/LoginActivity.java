package com.example.zohaib.eaitit4free;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String > {


    private ProgressDialog progress;
    private EditText mUserName;
    private EditText mUserPass;
    private static final String USGS_REQUEST_URL = "http://api.eat-it-4free.co.uk/api.php?action=signin&apisecretkey=NNTnnQEgzpDbcbudjQyz&apiuserkey=WebAPIE4F";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName=(EditText)findViewById(R.id.editusername);
        mUserPass=(EditText)findViewById(R.id.editpassword);
    }

    public void openRegisterActivity(View view)
    {
        Intent intent=new Intent(LoginActivity.this,RegisterUser.class);
        startActivity(intent);

    }
    public void openDetailActivity(View view)
    {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

//        LoaderManager loaderManager = getLoaderManager();
//
//        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
//        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
//        // because this activity implements the LoaderCallbacks interface).
//        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);


    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        progress=new ProgressDialog(this);
        progress.setMessage("Signing in");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();
        return new LoginLoader(getApplicationContext(),USGS_REQUEST_URL,mUserName.getText().toString(),mUserPass.getText().toString(),1);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {


        progress.dismiss();
        String result1=extractFeatureFromJson(s);

        if(result1==null ||result1.isEmpty())
        {

            Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_LONG).show();
            return;
        }
        ArrayList<UserOrder> myList=extractOrderDetails(s);
        String temp=mUserName.getText().toString().trim();
        String temp2=result1.trim();
        if(s!=null && temp.equals(temp2) ) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//           if(myList!=null) {
//               Bundle bundle = new Bundle();
//               bundle.putParcelableArrayList("ordrlist", myList);
//               intent.putExtras(bundle);
//           }
//            intent.putExtra("username",temp);



            startActivity(intent);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    public static String extractFeatureFromJson(String userJson)
    {
        try
        {

            JSONObject baseJSONresponse=new JSONObject(userJson);
            JSONObject currentObject=baseJSONresponse.getJSONObject("userdata");
            String userName=currentObject.getString("username");

            return userName;
        }
        catch (JSONException e)
        {

            return null;
        }

    }

    public static ArrayList<UserOrder> extractOrderDetails(String userJson)
    {

        ArrayList<UserOrder> myList=new ArrayList<UserOrder>();
        try
        {
            JSONObject baseJSONresponse=new JSONObject(userJson);
            JSONArray responseArray=baseJSONresponse.getJSONArray("previousorder");
            for(int i=0;i<responseArray.length();i++)
            {
                JSONObject currentObject=responseArray.getJSONObject(i);
                JSONObject resturantData=currentObject.getJSONObject("restaurant_data");
                JSONObject orderData=currentObject.getJSONObject("orderdata");
                JSONObject weekOne=orderData.getJSONObject("week_one");

                String restaurant_name=resturantData.getString("restaurant_name");
                String restaurant_logo=resturantData.getString("restaurant_logo");
                String order_number=weekOne.getString("order_number");
                UserOrder userOrder=new UserOrder(order_number,restaurant_name,restaurant_logo);
                myList.add(userOrder);
            }
        }
        catch (JSONException e)
        {

            return null;
        }
        catch (Exception e)
        {
            if(myList!=null)
            {
                return myList;
            }
            return null;
        }

        return myList;
    }






}
