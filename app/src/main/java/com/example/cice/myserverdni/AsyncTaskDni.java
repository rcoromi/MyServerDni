package com.example.cice.myserverdni;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cice on 25/3/17.
 */

public class AsyncTaskDni extends AsyncTask<String,Void, String>{

    private MainActivity mainActivity;
    private static final String URL_DNI="http://192.168.3.18:9090/DniApp/ServletCalculaDni?dni=";

    public AsyncTaskDni (MainActivity mainActivity)
    {
        this.mainActivity=mainActivity;

    }

    @Override
    protected String doInBackground(String... strings) {
        String mensaje_dni =null;
        URL url = null;
        HttpURLConnection httpURLConnection=null;
        InputStream is=null;
        int aux_c;

        try {
            url = new URL(URL_DNI + strings[0]);
            httpURLConnection =(HttpURLConnection)url.openConnection();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                is = httpURLConnection.getInputStream();
                InputStreamReader iss = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(iss);

                    mensaje_dni = br.readLine();
            }
        }
        catch (Throwable t)
        {
            Log.e("MENSAJE", "ERROR", t);
        }
        finally {
            httpURLConnection.disconnect();
        }
        return mensaje_dni;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(mainActivity,s,Toast.LENGTH_LONG).show();
    }
}
