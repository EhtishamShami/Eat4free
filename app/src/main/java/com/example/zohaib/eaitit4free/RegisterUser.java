package com.example.zohaib.eaitit4free;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterUser extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    private EditText fName;
    private EditText lName;
    private EditText mobile;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private RadioButton maleGender;
    private RadioButton femaleGender;


    private static final String USGS_REQUEST_URL = "http://api.eat-it-4free.co.uk/api.php?action=signup&apisecretkey=NNTnnQEgzpDbcbudjQyz&apiuserkey=WebAPIE4F";
    private static final int EARTHQUAKE_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        fName=(EditText)findViewById(R.id.firstname);
        lName=(EditText)findViewById(R.id.lastname);
        mobile=(EditText)findViewById(R.id.mobile);
        mEmail=(EditText)findViewById(R.id.userEmail);
        mPassword=(EditText)findViewById(R.id.enterPassword);
        mConfirmPassword=(EditText)findViewById(R.id.rePassword);
        maleGender=(RadioButton)findViewById(R.id.malecheck);
        femaleGender=(RadioButton)findViewById(R.id.femalecheck);

    }

    public void registerUser(View view)
    {
        Intent intent=new Intent(RegisterUser.this,LoginActivity.class);
        startActivity(intent);

//        LoaderManager loaderManager = getLoaderManager();
//
//        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
//        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
//        // because this activity implements the LoaderCallbacks interface).
//        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
    }
    public void openLoginActivity(View view)
    {
        Intent intent=new Intent(RegisterUser.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {

        if(maleGender.isChecked()) {
            return new LoginLoader(getApplicationContext(), USGS_REQUEST_URL, fName.getText().toString(),
                    lName.getText().toString(), mobile.getText().toString(), mEmail.getText().toString(),
                    mPassword.getText().toString(), "male", 2);
        }
        else
        {
            return new LoginLoader(getApplicationContext(), USGS_REQUEST_URL, fName.getText().toString(),
                    lName.getText().toString(), mobile.getText().toString(), mEmail.getText().toString(),
                    mPassword.getText().toString(), "female", 2);
        }
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {

        Intent intent=new Intent(RegisterUser.this,LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
