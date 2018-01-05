package com.example.zohaib.eaitit4free;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Zohaib on 12/31/2017.
 */

public class LoginLoader extends AsyncTaskLoader<String> {

    //for login
    String murl;
    String musername;
    String muserpass;

    // for registration
    String mfname;
    String mlname;
    String mmobile;
    String memaill;
    String mpass;
    String mgender;

    int mMode;

    public LoginLoader(Context context, String urll,String username,String pass,int mode) {
        super(context);
        murl=urll;
        musername=username;
        muserpass=pass;
        mMode=mode;
    }

    public LoginLoader(Context context,String urll,String fname,
                       String lname,String mobile,String emaill,String pass, String gender,int mode)
    {
        super(context);
        murl=urll;
        mfname=fname;
        mlname=lname;
        mmobile=mobile;
        memaill=emaill;
        mpass=pass;
        mgender=gender;
        mMode=mode;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        if (murl == null) {
            return null;
        }


        if(mMode==1) {
            String result = QueryUtils.fetchData(murl, musername, muserpass);
            return result;
        }
        else if(mMode==2)
        {
            String result = QueryUtils.fetchDataForRegistration(murl, mfname, mlname,mmobile,memaill,mpass,mgender);
            return result;
        }
        else
        {
            return null;
        }
    }

}
