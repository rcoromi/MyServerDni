package com.example.cice.myserverdni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaLetra (View view)
    {
        AsyncTaskDni asyncTaskDni = new AsyncTaskDni(this);
        EditText valor = (EditText) findViewById(R.id.cajadni);
        asyncTaskDni.execute(valor.getText().toString());
    }
}
